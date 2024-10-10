package lskim.accommodation_sample.jwt.util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import lskim.accommodation_sample.jwt.auth.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 1. 요청의 Authorization 헤더에서 JWT 토큰을 가져옵니다.
        String authorizationHeader = request.getHeader("Authorization");

        // 2. JWT가 존재하고 "Bearer "로 시작하면 토큰을 추출합니다.
        String token = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);  // "Bearer " 이후에 있는 실제 토큰 값만 추출합니다.
            log.info("Extracted JWT: {}", token);
        }

        // 3. 토큰이 유효한지 확인합니다.
        if (token != null && jwtUtil.validateToken(token)) {
            // 4. 토큰에서 유저 정보를 추출합니다.
            LoginUser loginUser = jwtUtil.getLoginUserFromAccessToken(token);
            log.info("Authenticated LoginUser: userNo = {}, userId = {}", loginUser.getUserNo(), loginUser.getUserId());

            // 5. Spring Security의 인증 객체에 이 유저 정보를 설정합니다.
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());

            // 6. SecurityContextHolder에 인증 정보를 저장합니다.
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 7. 다음 필터로 요청을 전달합니다.
        filterChain.doFilter(request, response);
    }
}
