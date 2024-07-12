package com.ohgiraffers.springeagles.khsBlog.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HSPostsRepository extends JpaRepository<HSPostsEntity, Integer> {

    Optional<HSPostsEntity> findById(Integer postId);
}