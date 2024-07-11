package com.ohgiraffers.springeagles.hjhBlog.likes.controller;

import com.ohgiraffers.springeagles.global.auth.service.CustomUserDetailsService;
import com.ohgiraffers.springeagles.hjhBlog.likes.service.JHLikesService;
import com.ohgiraffers.springeagles.hjhBlog.posts.service.JHPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hjh/blog")
public class JHLikesController {

    private final JHLikesService jhLikesService;
    private final JHPostsService jhPostsService;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public JHLikesController(JHLikesService jhLikesService, JHPostsService jhPostsService, CustomUserDetailsService customUserDetailsService) {
        this.jhLikesService = jhLikesService;
        this.jhPostsService = jhPostsService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/toggleLike")
    public ResponseEntity<Map<String, String>> toggleLike(@RequestParam("postId") Integer postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        boolean isLiked = jhLikesService.isPostLikedByUser(postId, username);
        if (isLiked) {
            jhLikesService.unlikePost(postId, username);
        } else {
            jhLikesService.likePost(postId, username);
        }

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", isLiked ? "Post unliked successfully" : "Post liked successfully");
        response.put("newState", isLiked ? "unliked" : "liked");


        return ResponseEntity.ok(response);
    }
}