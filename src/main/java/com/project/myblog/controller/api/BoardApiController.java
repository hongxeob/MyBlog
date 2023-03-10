package com.project.myblog.controller.api;

import com.project.myblog.config.auth.PrincipalDetails;
import com.project.myblog.dto.BoardDto;
import com.project.myblog.dto.ReplyDto;
import com.project.myblog.dto.ResponseDto;
import com.project.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> write(@RequestBody BoardDto boardDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        boardService.write(boardDto, principalDetails.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable Long id, @RequestBody BoardDto requestBoardDto) {
        boardService.update(id, requestBoardDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/api/board/{boardId}/reply")
    public ResponseDto<Integer> writeReply(@PathVariable("boardId") Long boardId, @RequestBody ReplyDto replyDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        boardService.writeReply(principalDetails.getUser(), boardId, replyDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public ResponseDto<Integer> deleteReply(@PathVariable("replyId") Long replyId) {
        boardService.deleteReply(replyId);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}