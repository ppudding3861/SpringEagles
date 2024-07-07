package com.ohgiraffers.springeagles.global.follow.service;

import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import com.ohgiraffers.springeagles.global.follow.model.FollowDTO;
import com.ohgiraffers.springeagles.global.follow.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowService {

    private final FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public void follow(UserEntity fromUser, UserEntity toUser) {

    }

    public List<FollowDTO> followingList(Optional<UserEntity> fromUser, Optional<UserEntity> requestUser) {
        return null;
    }

    public List<FollowDTO> followerList(Optional<UserEntity> toUser, Optional<UserEntity> requestUser) {
        return null;
    }

    public void cancelFollow(UserEntity user) {

    }
}
