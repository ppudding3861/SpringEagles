package com.ohgiraffers.springeagles.jstBlog.likes.controller;

import com.ohgiraffers.springeagles.global.auth.service.CustomUserDetailsService;
import com.ohgiraffers.springeagles.jstBlog.likes.service.STLikesService;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stj/blog")
public class STLikesController {

    private final STLikesService stLikesService;
    private final STPostsService stPostsService;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public STLikesController(STLikesService stLikesService, STPostsService stPostsService, CustomUserDetailsService customUserDetailsService) {
        this.stLikesService = stLikesService;
        this.stPostsService = stPostsService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/toggleLike")
    public ResponseEntity<Map<String, String>> toggleLike(@RequestParam("postId") Integer postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        boolean isLiked = stLikesService.isPostLikedByUser(postId, username);
        if (isLiked) {
            stLikesService.unlikePost(postId, username);
        } else {
            stLikesService.likePost(postId, username);
        }

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", isLiked ? "Post unliked successfully" : "Post liked successfully");
        response.put("newState", isLiked ? "unliked" : "liked");

        System.out.println(response); // 응답 객체를 콘솔에 출력하여 디버깅

        return ResponseEntity.ok(response);
    }
}
