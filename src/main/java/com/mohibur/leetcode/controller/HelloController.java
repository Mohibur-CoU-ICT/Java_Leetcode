package com.mohibur.leetcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping
    public String welcome() {
        return "Welcome to my problem solving platform.";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
