package com.project.myblog.controller;

import com.project.myblog.model.Board;
import com.project.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    // 전체 글 보기
    @GetMapping({"", "/"})
    public String index(Model model, @PageableDefault(size = 5, sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> board = boardService.list(pageable);
        model.addAttribute("boards", board);
        return "index";
    }

    @GetMapping("/board/writeForm")
    public String writeForm() {
        return "board/writeForm";
    }

    @GetMapping("/board/{id}")
    public String articles(@PathVariable Long id, Model model) {
        Board articles = boardService.details(id);
        boardService.updateViews(id);
        model.addAttribute("board", articles);
        return "board/articles";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable Long id, Model model) {
        Board articles = boardService.details(id);
        model.addAttribute("board", articles);
        return "board/updateForm";
    }
}
