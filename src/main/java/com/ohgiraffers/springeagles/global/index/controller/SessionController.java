package com.ohgiraffers.springeagles.global.index.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @PostMapping("/clear-login-success")
    public void clearLoginSuccess(HttpSession session) {
        session.removeAttribute("loginSuccess");
    }
}
