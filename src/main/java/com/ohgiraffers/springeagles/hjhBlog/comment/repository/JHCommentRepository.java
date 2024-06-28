package com.ohgiraffers.springeagles.hjhBlog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JHCommentRepository extends JpaRepository<JHCommentEntity, Long> {
    List<JHCommentEntity> findByPostsEntity_Id(Long postId);
}