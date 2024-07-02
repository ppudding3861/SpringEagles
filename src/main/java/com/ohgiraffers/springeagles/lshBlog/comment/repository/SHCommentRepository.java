package com.ohgiraffers.springeagles.lshBlog.comment.repository;

import com.ohgiraffers.springeagles.lshBlog.comment.model.entity.SHCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SHCommentRepository extends JpaRepository<SHCommentEntity, Integer> {
}
