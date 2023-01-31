package com.project.myblog.controller;

import com.project.myblog.config.auth.PrincipalDetail;
import com.project.myblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 인증이 필요없는 경로 auth/** 허용
// 그리고 그냥 주소가 / 이면 index.html 허용
// static 이하에 있는 /js/** , /css/**, /image/** 허용
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm(Model model, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        model.addAttribute("principal", principalDetail.getUser());
        userService.update(principalDetail.getUser());
        return "user/updateForm";
    }
}
