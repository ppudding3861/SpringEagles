package com.ohgiraffers.springeagles.jstBlog.comment.controller;

import com.ohgiraffers.springeagles.jstBlog.comment.service.STCommentService;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("blog")
public class STCommentController {

    private final STPostsService STPostsService;
    private final STCommentService STCommentService;

    @Autowired
    public STCommentController(STCommentService STCommentService, STPostsService STPostsService) {
        this.STPostsService = STPostsService;
        this.STCommentService = STCommentService;
    }

}
