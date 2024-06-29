package com.ohgiraffers.springeagles.khsBlog.posts.controller;

import com.ohgiraffers.springeagles.khsBlog.posts.service.HSPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogPost4")
public class HSAddPostController {

    private HSPostsService hsPostsService;

    @Autowired
    public HSAddPostController(HSPostsService hsPostsService) {
        this.hsPostsService = hsPostsService;
    }

}
