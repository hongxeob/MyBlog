package com.project.myblog.dto;

import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createDateTime;
    private RoleType role;

    @Builder
    public UserDto(Long id, String username, String password, String email, LocalDateTime createDateTime, RoleType role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createDateTime = createDateTime;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .createDateTime(createDateTime)
                .role(role)
                .build();
    }

    public void updateUser(String password, String email) {
        this.password = password;
        this.email = email;
    }
}
