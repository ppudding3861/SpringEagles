package com.ohgiraffers.springeagles.jstBlog.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface STLikesRepository extends JpaRepository<STLikesEntity, Integer> {
    boolean existsByPost_PostIdAndUserId(Integer postId, Integer userId);
    void deleteByPost_PostIdAndUserId(Integer postId, Integer userId);
    List<STLikesEntity> findByUserId(Integer userId);
    int countByPost_PostId(Integer postId);
}