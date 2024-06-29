package com.ohgiraffers.springeagles.jstBlog.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STPostsRepository extends JpaRepository<STPostsEntity, Integer> {
}