package com.ohgiraffers.springeagles.hjhBlog.likes.repository;

import com.ohgiraffers.springeagles.hjhBlog.likes.entity.JHLikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JHLikesRepository extends JpaRepository<JHLikesEntity, Integer> {
    boolean existsByPost_PostIdAndUserId(Integer postId, Integer userId);
    void deleteByPost_PostIdAndUserId(Integer postId, Integer userId);
    List<JHLikesEntity> findByUserId(Integer userId);
    int countByPost_PostId(Integer postId);
}