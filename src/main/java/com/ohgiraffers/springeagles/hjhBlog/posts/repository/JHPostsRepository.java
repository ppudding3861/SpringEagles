package com.ohgiraffers.springeagles.hjhBlog.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JHPostsRepository extends JpaRepository<JHPostsEntity, Integer> {

}