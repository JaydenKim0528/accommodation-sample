package lskim.accommodation_sample.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import lskim.accommodation_sample.jwt.auth.LoginUser;
import lskim.accommodation_sample.jwt.exception.ExpiredTokenException;
import lskim.accommodation_sample.jwt.exception.InvalidTokenException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    private SecretKey key;  // JWT를 서명하는 데 사용할 시크릿 키
    private static final String KEY_FILE_PATH = "D:\\Project\\key\\secret.key";  // 시크릿 키를 저장할 파일 경로
    private static final Long EXPIRATION_TIME_MS = 1000 * 60 * 60 * 24L;  // 토큰 만료 시간 (24시간)
    private static final String USER_NO_KEY_NAME = "userNo";  // 사용자 번호를 담을 claim 키 이름
    private static final String USER_ID_KEY_NAME = "userId";  // 사용자 ID를 담을 claim 키 이름

    // JwtUtil 생성자 - 객체가 생성될 때 시크릿 키를 초기화
    public JwtUtil() {
        this.generateSecretKey();  // 시크릿 키 생성
    }

    // 시크릿키 블러오기
    @PostConstruct
    public void init() {
        loadSecretKey();
    }

    // 파일에서 시크릿 키를 불러오는 메서드입니다.
    private void loadSecretKey() {
        try {
            // 시크릿 키 파일이 존재하는지 확인
            if (Files.exists(Paths.get(KEY_FILE_PATH))) {
                // 파일에서 시크릿 키를 읽어와 디코딩하고, SecretKey 객체로 변환
                byte[] keyBytes = Base64.getDecoder().decode(Files.readAllBytes(Paths.get(KEY_FILE_PATH)));
                this.key = Keys.hmacShaKeyFor(keyBytes);  // 읽어온 시크릿 키로 SecretKey 생성
                log.info("시크릿 키가 정상적으로 로드되었습니다.");
            } else {
                log.info("시크릿 키 파일을 찾을 수 없습니다. 새로운 키를 생성합니다.");
                generateSecretKey();  // 키 파일이 없다면 새로 생성
            }
        } catch (IOException e) {
            throw new RuntimeException("시크릿 키 로드 중 오류 발생", e);
        }
    }

    // 매달 1일 자정에 새로운 시크릿 키를 생성
    @Scheduled(cron = "0 0 0 1 * ?")  // 매달 1일 0시에 실행
    private void generateSecretKey() {
        // 시크릿 키를 랜덤으로 생성합니다.
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[64];  // 512비트 크기의 키 (64바이트)
        random.nextBytes(keyBytes);  // 랜덤 값으로 채움
        this.key = Keys.hmacShaKeyFor(keyBytes);  // SecretKey 객체로 변환
        log.info("새로운 시크릿 키가 생성되었습니다.");

        // 시크릿 키를 파일에 저장
        try (FileOutputStream fos = new FileOutputStream(KEY_FILE_PATH)) {
            fos.write(Base64.getEncoder().encode(keyBytes));  // 시크릿 키를 인코딩하여 파일에 저장
        } catch (IOException e) {
            throw new RuntimeException("시크릿 키 저장 실패", e);
        }
    }

    // JWT 토큰을 생성
    public String createAccessToken(final LoginUser loginUser) {
        log.info("Generated JWT: {}", Jwts.builder()
                .setSubject(loginUser.getUserId())
                .claim(USER_NO_KEY_NAME, loginUser.getUserNo())
                .claim(USER_ID_KEY_NAME, loginUser.getUserId())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS))
                .signWith(key)
                .compact());


        // JWT 토큰 생성 - 사용자 ID, 번호, 만료 시간, 서명 등을 포함
        return Jwts.builder()
                .setSubject(loginUser.getUserId())  // 토큰의 주제는 사용자 ID
                .claim(USER_NO_KEY_NAME, loginUser.getUserNo())  // 사용자 번호를 claim에 저장
                .claim(USER_ID_KEY_NAME, loginUser.getUserId())  // 사용자 ID를 claim에 저장
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS))  // 만료 시간 설정
                .signWith(key)  // 시크릿 키로 서명
                .compact();  // 최종적으로 토큰 생성
    }

    // JWT에서 사용자 정보를 꺼내기
    public LoginUser getLoginUserFromAccessToken(final String accessToken) {
        Claims claims = getClaims(accessToken);  // 토큰에서 claim 추출
        return new LoginUser(claims.get(USER_NO_KEY_NAME, Long.class), claims.get(USER_ID_KEY_NAME, String.class));  // claim에서 사용자 정보 추출
    }

    // JWT에서 클레임 정보를 추출
    private Claims getClaims(final String accessToken) {
        Claims claims;
        try {
            // 토큰을 파싱하여 claim 추출
            claims = Jwts.parserBuilder()
                    .setSigningKey(key)  // 시크릿 키로 서명 검증
                    .build()
                    .parseClaimsJws(accessToken)  // 토큰 파싱
                    .getBody();  // claim 정보 반환
        } catch (ExpiredJwtException eje) {
            throw new ExpiredTokenException();  // 토큰이 만료되었을 때 예외 처리
        } catch (Exception e) {
            throw new InvalidTokenException();  // 토큰이 유효하지 않을 때 예외 처리
        }
        return claims;
    }

    // JWT 토큰이 유효성 검사
    public boolean validateToken(String token) {
        try {
            // 시크릿 키로 토큰을 검증
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;  // 검증에 성공하면 true 반환
        } catch (JwtException | IllegalArgumentException e) {
            // 토큰이 유효하지 않은 경우 false 반환
            return false;
        }
    }
}
