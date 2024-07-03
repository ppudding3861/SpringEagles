package com.ohgiraffers.springeagles.kkhBlog.posts;

import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public interface PostsRepository extends JpaRepository<PostsEntity, Long> {
}