package com.project.myblog.service;

import com.project.myblog.dto.request.UserSaveRequestDto;
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
    public void join(UserSaveRequestDto userSaveRequestDto) {
        String originPassword = userSaveRequestDto.getPassword();
        String encodePassword = encoder.encode(originPassword);
        userSaveRequestDto.setPassword(encodePassword);
        User user = userSaveRequestDto.toEntity();
        userRepository.save(user);
    }


    @Transactional
    public void update(User user) {
        User findUser = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다"));

        if (findUser.getProvider() == null || findUser.getProvider().equals("")) {
            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword);
            findUser.updatePassword(encPassword);
        }
        findUser.updateEmail(user.getEmail());
    }

    @Transactional(readOnly = true)
    public User findUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            new User();
        }
        return user;
    }
}