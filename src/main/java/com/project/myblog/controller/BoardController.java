package com.project.myblog.controller;

import com.project.myblog.config.auth.PrincipalDetail;
import com.project.myblog.model.Board;
import com.project.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    // 전체 글 보기
    @GetMapping({"", "/"})
    public String index(Model model) {
        List<Board> board = boardService.list();
        model.addAttribute("boards", board);
        return "index";
    }

    @GetMapping("/board/writeForm")
    public String writeForm() {
        return "board/writeForm";
    }
}
