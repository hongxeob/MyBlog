package com.project.myblog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>hello my world</h1>";
    }
}
