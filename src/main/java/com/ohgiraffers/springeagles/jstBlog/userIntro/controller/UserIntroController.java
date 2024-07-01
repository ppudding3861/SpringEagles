package com.ohgiraffers.springeagles.jstBlog.userIntro.controller;

import com.ohgiraffers.springeagles.jstBlog.userIntro.service.UserIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stj/blog")
public class UserIntroController {

    private final UserIntroService userIntroService;

    @Autowired
    public UserIntroController(UserIntroService userIntroService) {
        this.userIntroService = userIntroService;
    }

    @PostMapping("/updateIntro")
    public ResponseEntity<String> updateIntro(@RequestBody String userIntroContent) {
        try {
            userIntroService.saveOrUpdateIntroContent(userIntroContent); // 게시물 생성 서비스 호출
            return ResponseEntity.ok("게시물 작성이 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 작성 중 오류가 발생했습니다.");
        }
    }
}