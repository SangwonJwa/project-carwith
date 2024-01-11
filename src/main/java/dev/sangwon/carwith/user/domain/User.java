package dev.sangwon.carwith.user.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // 회원 번호 (고유값, 식별용)
    
    private String email; // 이메일 (로그인 시 필요)
    private String password; // 패스워드 (로그인 시 필요)
    private String userName; // 사용자 이름
    private String imgUrl; // 프로필 사진
    private String phone; // 전화번호

    @Column(name = "score", columnDefinition = "DOUBLE DEFAULT 0.0")  // 평점
    private Double score;

    @Builder
    public User(Integer id, String email, String password, String userName, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
    }

    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        // TODO: 계정 만료 확인 로직
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO: 계정 잠금 확인 로직
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO: 패스워드 만료 확인 로직
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO: 계정 사용 가능 확인 로직
        return true;
    }
}
