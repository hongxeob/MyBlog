package com.project.myblog.service;

import com.project.myblog.config.auth.PrincipalDetail;
import com.project.myblog.model.User;
import com.project.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    @Transactional
    public void join(User user) {
        String originPassword = user.getPassword();
        String encodePassword = encoder.encode(originPassword);
        user.setPassword(encodePassword);
        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
            return new IllegalArgumentException("회원을 찾을 수 없습니다");
        });
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        findUser.setPassword(encPassword);
        findUser.setEmail(user.getEmail());
    }
}
