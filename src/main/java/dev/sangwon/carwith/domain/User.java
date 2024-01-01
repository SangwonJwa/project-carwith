package dev.sangwon.carwith.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column(length = 11)
    private String phoneNumber;

    @Column
    private String imageUrl;

    @Column(length = 1)
    private String gender;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Builder
    public User(String email, String password,
                String name, String phoneNumber,
                String imageUrl, String gender,
                String nickname){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.gender = gender;
        this.nickname = nickname;
    }

    public User update(String name,
                       String phoneNumber,
                       String imageUrl){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;

        return this;
    }

    public User update(String nickname){
        this.nickname = nickname;

        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        //TODO: 계정 만료 확인 로직
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //TODO: 계정 잠금 확인 로직
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //TODO: 패스워드 만료 확인 로직
        return true;
    }

    @Override
    public boolean isEnabled() {
        //TODO: 계정 사용 가능 여부 확인 로직
        return true;
    }
}


