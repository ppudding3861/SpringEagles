package com.ohgiraffers.springeagles.khsBlog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HSCommentRepository extends JpaRepository<HSCommentEntity, Long> {
    List<HSCommentEntity> findByPostsEntity_Id(Long postId);
}