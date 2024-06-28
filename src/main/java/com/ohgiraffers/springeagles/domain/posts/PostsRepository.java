package com.ohgiraffers.springeagles.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, Long> {
    // 추가적인 메서드가 필요하다면 여기에 작성할 수 있습니다.
}