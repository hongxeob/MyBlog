package com.project.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// 인증이 필요없는 경로 auth/** 허용
// 그리고 그냥 주소가 / 이면 index.html 허용
// static 이하에 있는 /js/** , /css/**, /image/** 허용
@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }
}
