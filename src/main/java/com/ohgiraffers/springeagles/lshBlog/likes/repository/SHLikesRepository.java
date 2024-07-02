package com.ohgiraffers.springeagles.lshBlog.likes.repository;

import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SHLikesRepository extends JpaRepository<SHPostsEntity, Integer> {
}
