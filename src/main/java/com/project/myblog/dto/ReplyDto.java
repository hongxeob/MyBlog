package com.project.myblog.dto;

import com.project.myblog.model.Board;
import com.project.myblog.model.Reply;
import com.project.myblog.model.User;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ReplyDto {
    private String content;
    private Board board;
    private User user;

    public Reply toEntity() {
        return Reply.builder()
                .content(content)
                .board(board)
                .user(user)
                .build();
    }
}
