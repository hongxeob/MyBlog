package com.project.myblog.repository;

import com.project.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {




    /**
     * 일반 로그인시
     */
    // JPA Naming Query 전략
    // SELECT * FROM user WHERE username = ? AND password = ?;
//    User findByUsernameAndPassword(String username, String password);
}
