package com.project.myblog.controller.api;

import com.project.myblog.config.auth.PrincipalDetail;
import com.project.myblog.dto.ResponseDto;
import com.project.myblog.model.Board;
import com.project.myblog.model.RoleType;
import com.project.myblog.model.User;
import com.project.myblog.service.BoardService;
import com.project.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> write(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardService.write(board, principalDetail.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}