package com.project.myblog.dto;

import com.project.myblog.model.Board;
import com.project.myblog.model.Reply;
import com.project.myblog.model.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDto {
    private Long id;
    private String content;
    private Board board;
    private User user;

    //request 용도
    public Reply toEntity() {
        return Reply.builder()
                .id(id)
                .content(content)
                .board(board)
                .user(user)
                .build();
    }

    //response 용도
    public ReplyDto toDto(Reply reply) {
        this.id = reply.getId();
        this.content = reply.getContent();
        this.board = reply.getBoard();
        this.user = reply.getUser();
        return this;
    }

}
