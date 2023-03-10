package com.project.myblog.config.auth;

import com.project.myblog.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고, 완료가 되면 UserDetails 타입의 오브젝트를 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
public class PrincipalDetails implements UserDetails, OAuth2User { //UserDetails = Spring Security 에서 사용자의 정보를 담는 인터페이스

    private User user;
    public Map<String, Object> attributes;


    //UserDetails : Form 로그인 시 사용
    public PrincipalDetails(User user) {
        this.user = user;
    }

    //OAuth2User : OAuth2 로그인 시 사용
    public PrincipalDetails(User user, Map<String, Object> attributes) {
        //PrincipalOauth2UserService 참고
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public User getUser() {
        return user;
    }

    @Override
    //계정의 권한 목록 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(() -> {
            return "ROLE_" + user.getRole();
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    //계정 만료 여부 (true:만료X)
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //계정 잠김 여부 (true:잠김X)
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //비밀번호 만료 여부 (true:만료X)
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //계정이 사용 가능한지 (true:활성화(사용가능)
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getName() {
        return null;
    }
}
