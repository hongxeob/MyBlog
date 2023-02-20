package com.project.myblog.repository;

import com.project.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //PrincipalDetailService 에서 username 으로 찾기 위함
    //select * from user where username=?;
//    Optional<User> findByUsername(String username);
    User findByUsername(String username);

    /**
     * 일반 로그인시
     */
    // JPA Naming Query 전략
    // SELECT * FROM user WHERE username = ? AND password = ?;
//    User findByUsernameAndPassword(String username, String password);
}
