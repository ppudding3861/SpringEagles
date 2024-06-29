package com.ohgiraffers.springeagles.jstBlog.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STCommentRepository extends JpaRepository<STCommentEntity, Integer> {

}