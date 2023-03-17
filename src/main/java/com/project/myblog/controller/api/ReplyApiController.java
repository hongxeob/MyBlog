package com.project.myblog.controller.api;

import com.project.myblog.config.auth.PrincipalDetails;
import com.project.myblog.dto.ReplyDto;
import com.project.myblog.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReplyApiController {
    private final ReplyService replyService;

    @PostMapping("/api/board/{boardId}/reply")
    public ResponseEntity writeReply(@PathVariable("boardId") Long boardId, @RequestBody ReplyDto replyDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        return ResponseEntity.ok(replyService.writeReply(principalDetails.getUser(), boardId, replyDto));
    }

    @GetMapping("/api/board/{boardId}/replys")
    public ResponseEntity replyList(@PathVariable Long boardId) {
        return ResponseEntity.ok(replyService.findAll(boardId));
    }
    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public ResponseEntity<Long> deleteReply(@PathVariable("replyId") Long replyId) {
        replyService.deleteReply(replyId);
        return ResponseEntity.ok(replyId);
    }
}
