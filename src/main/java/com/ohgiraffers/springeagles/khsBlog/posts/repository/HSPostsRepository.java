package com.ohgiraffers.springeagles.khsBlog.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// HSPostsRepository 인터페이스는 HSPostsEntity와 관련된 데이터베이스 작업을 수행하는 리포지토리입니다.
// JpaRepository를 상속받아 기본적인 CRUD 작업을 지원합니다.
@Repository
public interface HSPostsRepository extends JpaRepository<HSPostsEntity, Integer> {
    // JpaRepository<엔티티 클래스, 엔티티의 ID 타입>을 상속받아 구현됩니다.
    // 기본적인 CRUD 메서드(save, findById, findAll, delete 등)를 자동으로 제공합니다.
}