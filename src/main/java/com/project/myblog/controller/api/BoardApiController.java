package com.project.myblog.controller.api;

import com.project.myblog.config.auth.PrincipalDetails;
import com.project.myblog.dto.BoardDto;
import com.project.myblog.dto.ReplyDto;
import com.project.myblog.dto.ResponseDto;
import com.project.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;


    @PostMapping("/api/board")
    public ResponseEntity write(@RequestBody BoardDto boardDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        return ResponseEntity.ok(boardService.write(boardDto, principalDetails.getUser()));
    }

    @GetMapping("/api/board/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.findById(id));
    }
    @GetMapping("/api/boards")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(boardService.findAll());
    }
    @DeleteMapping("/api/board/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/api/board/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody BoardDto requestBoardDto) {
        boardService.update(id, requestBoardDto);
        return ResponseEntity.ok(id);
    }

}