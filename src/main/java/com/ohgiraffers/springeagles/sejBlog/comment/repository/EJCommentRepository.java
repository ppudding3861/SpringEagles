package com.ohgiraffers.springeagles.sejBlog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EJCommentRepository extends JpaRepository<EJCommentEntity, Long> {
    List<EJCommentEntity> findByPostsEntity_Id(Long postId);
}