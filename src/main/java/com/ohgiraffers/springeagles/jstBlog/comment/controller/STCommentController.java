package com.ohgiraffers.springeagles.jstBlog.comment.controller;

import com.ohgiraffers.springeagles.jstBlog.comment.service.STCommentService;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/stj/blog")
public class STCommentController {

    private final STPostsService sTPostsService;
    private final STCommentService sTCommentService;

    @Autowired
    public STCommentController(STCommentService sTCommentService, STPostsService sTPostsService) {
        this.sTCommentService = sTCommentService;
        this.sTPostsService = sTPostsService;
    }

    // 저장관련 로직
    @PostMapping("/savecomment")
    public String saveComment(@RequestParam("userName") String userName,
                              @RequestParam("postId") Integer postId,
                              @RequestParam("comment") String commentContent) {
        sTCommentService.saveComment(userName, postId, commentContent);
        return "redirect:/stj/blog/post/" + postId;
    }

    // 삭제관련 로직
    @PostMapping("/deletecomment")
    public String deleteComment(@RequestParam("commentId") Integer commentId,
                                @RequestParam("postId") Integer postId) {
        sTCommentService.deleteCommentById(commentId);
        return "redirect:/stj/blog/post/" + postId;
    }

    // 수정관련 로직
    @PostMapping("/updatecomment")
    public String updateComment(@RequestParam("commentId") Integer commentId,
                                @RequestParam("postId") Integer postId,
                                @RequestParam("comment") String commentContent) {
        sTCommentService.updateComment(commentId, commentContent);
        return "redirect:/stj/blog/post/" + postId;
    }
}
