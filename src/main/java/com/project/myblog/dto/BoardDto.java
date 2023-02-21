package com.project.myblog.dto;

import com.project.myblog.model.Board;
import com.project.myblog.model.User;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BoardDto {
    private Long id;
    @NonNull
    private String title;
    private String content;
    private String category;
    private int views;
    private User user;

    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .category(category)
                .views(views)
                .user(user)
                .build();
    }
}



