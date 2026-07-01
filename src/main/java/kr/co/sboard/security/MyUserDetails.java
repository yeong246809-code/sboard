package kr.co.sboard.security;

import kr.co.sboard.entity.UserEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
public class MyUserDetails implements UserDetails {
    /*
    UserDetails
    -스프링 시큐리티 사용자 인증 객체
    - security context holder(session)에 저장되는 인증 객체
    - 로그인 성공 후 User 엔티티를 세션 보관
     */

    //user 엔티티
    private UserEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //권한 목록 생성
        List<GrantedAuthority> auList = new ArrayList<>();
        String role = user.getRole().toUpperCase();

        auList.add(new SimpleGrantedAuthority("ROLE_" + role));


        return auList;
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return user.getUserid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //권한 목록 생성



}
