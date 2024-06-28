package com.ohgiraffers.springeagles.jstBlog.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STPostsRepository extends JpaRepository<STPostsEntity, Long> {
    // 추가적인 메서드가 필요하다면 여기에 작성할 수 있습니다.
}