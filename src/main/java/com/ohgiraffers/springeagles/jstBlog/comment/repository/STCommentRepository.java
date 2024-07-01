package com.ohgiraffers.springeagles.jstBlog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface STCommentRepository extends JpaRepository<STCommentEntity, Integer> {
    List<STCommentEntity> findByPostId(Integer postId);
}