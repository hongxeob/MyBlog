package com.project.myblog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.myblog.model.Board;
import com.project.myblog.model.Reply;
import com.project.myblog.model.User;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
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
    private List<Reply> replyList;

    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .category(category)
                .views(views)
                .user(user)
                .replyList(replyList)
                .build();
    }

    public BoardDto toDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.category = board.getCategory();
        this.views = board.getViews();
        this.user = board.getUser();
        this.replyList = board.getReplyList();
        return this;
    }
}



