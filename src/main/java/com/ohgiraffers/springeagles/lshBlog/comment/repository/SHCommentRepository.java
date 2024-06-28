package com.ohgiraffers.springeagles.lshBlog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SHCommentRepository extends JpaRepository<SHCommentEntity, Long> {
    List<SHCommentEntity> findByPostsEntity_Id(Long postId);
}