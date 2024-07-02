package com.ohgiraffers.springeagles.sejBlog.comment.repository;

import com.ohgiraffers.springeagles.sejBlog.comment.model.entity.EJCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EJCommentRepository extends JpaRepository<EJCommentEntity, Integer> {
}
