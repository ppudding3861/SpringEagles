package com.ohgiraffers.springeagles.jstBlog.comment.repository;

import com.ohgiraffers.springeagles.jstBlog.comment.entity.STReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface STReplyRepository extends JpaRepository<STReplyEntity, Integer> {
    List<STReplyEntity> findByCommentCommentId(Integer commentId);
}
