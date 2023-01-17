package com.project.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    // 전체 글 보기
    @GetMapping({"", "/"})
    public String index() {
        return "home";
    }
}
