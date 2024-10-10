package lskim.accommodation_sample.jwt.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@ToString
public class LoginUser {
    
    @NotNull
    private long userNo;
    
    @NotNull
    private String userId;

    // 사용자의 권한을 저장
    private List<String> roles;

    public LoginUser(long userNo, String userId) {
        this.userNo = userNo;
        this.userId = userId;
        this.roles = new ArrayList<>();
    }

    // 권한을 설정
    public void addRole(String role) {
        roles.add(role);
    }

    // Spring Security에서 요구하는 권한 리스트를 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));  // 역할을 GrantedAuthority로 변환
        }
        return authorities;
    }
}
