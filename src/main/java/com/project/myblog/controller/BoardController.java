package com.project.myblog.controller;

import com.project.myblog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    // 전체 글 보기
    @GetMapping({"", "/"})
    public String index(@AuthenticationPrincipal PrincipalDetail principalDetail) {
        return "index";
    }
}
