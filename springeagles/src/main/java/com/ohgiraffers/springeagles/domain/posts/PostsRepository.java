package com.ohgiraffers.springeagles.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, Long> {
    // 추가적으로 필요한 메서드가 있다면 여기에 추가할 수 있습니다.
}