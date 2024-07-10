package com.ohgiraffers.springeagles.khsBlog.likes.repository;

import com.ohgiraffers.springeagles.khsBlog.likes.entity.HSLikesEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HSLikesRepository extends JpaRepository<HSLikesEntity, Integer> {
    HSLikesEntity findByPost(HSPostsEntity post);
}
