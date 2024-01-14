package dev.sangwon.carwith.member.service;

import dev.sangwon.carwith.member.domain.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails {

    String userName = null;
    String password = null;
    List<GrantedAuthority> authorities;


    public UserInfoDetails(UserInfo userInfo){
        userName = userInfo.getEmail();
        password = userInfo.getPassword();
        authorities = Arrays.stream(userInfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
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
        // TODO: 비밀번호 만료 확인 로직
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO: 계정 사용 가능 여부 확인 로직
        return true;
    }
}
