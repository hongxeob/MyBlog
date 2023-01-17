package com.project.myblog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createDateTime;

    @PrePersist //DB에 insert되기 직전 실행! DB에 값을 넣으면 자동으로 실행
    public void createdAt() {
        this.createDateTime = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING) //DB는 RoleType에 대한 정보를 모르기에 각 Enum 이름(String)을 컬럼에 저장
    private RoleType role;

}
