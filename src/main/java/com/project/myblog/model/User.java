package com.project.myblog.model;

import com.project.myblog.dto.response.UserResponseDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

//@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySQL에 자동으로 테이블 생성
public class User {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY 전략은 기본 키 생성을 프로젝트에 연결된 데이터베이스에 위임하는 전략
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Enumerated(EnumType.STRING) //DB는 RoleType에 대한 정보를 모르기에 각 Enum 이름(String)을 컬럼에 저장
    private RoleType role;

    public void updateUser(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public UserResponseDto toDto() {
        return UserResponseDto.builder()
                .id(id)
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}
