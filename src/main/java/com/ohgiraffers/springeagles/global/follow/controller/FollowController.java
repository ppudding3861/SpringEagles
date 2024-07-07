package com.ohgiraffers.springeagles.global.follow.controller;

import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import com.ohgiraffers.springeagles.global.auth.service.CustomUserDetailsService;
import com.ohgiraffers.springeagles.global.follow.model.FollowDTO;
import com.ohgiraffers.springeagles.global.follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FollowController {

    private final FollowService followService;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public FollowController(FollowService followService, CustomUserDetailsService customUserDetailsService) {
        this.followService = followService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/follow/{friendName}")
    public ResponseEntity<?> follow(Authentication authentication, @PathVariable("friendName") String friendName) {
        Optional<UserEntity> from_user = customUserDetailsService.findByUserName(authentication.getName());
        Optional<UserEntity> to_user = customUserDetailsService.findByUserName(friendName);
        from_user.ifPresent(fUser -> to_user.ifPresent(tUser -> followService.follow(fUser, tUser)));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userName}/following")
    public ResponseEntity<List<FollowDTO>> getFollowingList(@PathVariable("userName") String userName, Authentication auth) {
        Optional<UserEntity> from_user = customUserDetailsService.findByUserName(userName);
        Optional<UserEntity> requestUser = customUserDetailsService.findByUserName(auth.getName());
        return ResponseEntity.ok().body(followService.followingList(from_user, requestUser));
    }

    @GetMapping("/{userName}/follower")
    public ResponseEntity<List<FollowDTO>> getFollowerList(@PathVariable("userName") String userName, Authentication auth) {
        Optional<UserEntity> to_user = customUserDetailsService.findByUserName(userName);
        Optional<UserEntity> requestUser = customUserDetailsService.findByUserName(auth.getName());
        return ResponseEntity.ok().body(followService.followerList(to_user, requestUser));
    }

    @DeleteMapping("/follow/{friendName}")
    public ResponseEntity<String> deleteFollow(Authentication authentication) {
        customUserDetailsService.findByUserName(authentication.getName()).ifPresent(user -> followService.cancelFollow(user));
        return ResponseEntity.ok().build();
    }
}
