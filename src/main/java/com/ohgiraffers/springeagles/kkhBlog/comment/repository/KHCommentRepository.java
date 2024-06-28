package com.ohgiraffers.springeagles.kkhBlog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KHCommentRepository extends JpaRepository<KHCommentEntity, Long> {
    List<KHCommentEntity> findByPostsEntity_Id(Long postId);
}