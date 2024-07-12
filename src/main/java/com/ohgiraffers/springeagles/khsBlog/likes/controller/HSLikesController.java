package com.ohgiraffers.springeagles.khsBlog.likes.controller;

import com.ohgiraffers.springeagles.khsBlog.likes.repository.HSLikesRepository;
import com.ohgiraffers.springeagles.khsBlog.likes.service.HSLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/khs/blog")
public class HSLikesController {

    private final HSLikesRepository likesRepository;
    private final HSLikeService likeService;

    @Autowired
    public HSLikesController(HSLikesRepository likesRepository, HSLikeService likeService) {
        this.likesRepository = likesRepository;
        this.likeService = likeService;
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<String> likePost(@PathVariable("postId") Integer postId) {
        likeService.likePost(postId);
        return ResponseEntity.ok().body("Successfully liked post");
    }

    }
