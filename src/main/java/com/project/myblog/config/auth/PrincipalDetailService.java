package com.project.myblog.config.auth;

import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// 스프링이 로그인 요청을 가로챌 때, username, password 변수 2개를 가로채는데
// password 부분 처리는 알아서 함
// username 이 DB에 있는지만 확인해주면 됨
// 밑에 Override 된 함수에서 username 확인을함
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("해당 유저 찾을 수 없습니다😂");
        }
        return new PrincipalDetails(user); //시큐리티 세션에 유저 정보가 저장됨
    }

}
