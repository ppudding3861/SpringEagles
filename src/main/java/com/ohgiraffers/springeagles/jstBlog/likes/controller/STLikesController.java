package com.ohgiraffers.springeagles.jstBlog.likes.controller;

import com.ohgiraffers.springeagles.global.auth.service.CustomUserDetailsService;
import com.ohgiraffers.springeagles.jstBlog.likes.service.STLikesService;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
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


    @PostMapping("/likes")
    public ResponseEntity<Map<String, String>> likePost(@RequestParam("postId") Integer postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        stLikesService.likePost(postId, username);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Post liked successfully");
        response.put("redirectUrl", "/stj/blog/post/" + postId);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/unlikes")
    public ResponseEntity<Map<String, String>> unlikePost(@RequestParam("postId") Integer postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        stLikesService.unlikePost(postId, username);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Post unliked successfully");
        response.put("redirectUrl", "/stj/blog/post/" + postId);

        return ResponseEntity.ok(response);
    }
}