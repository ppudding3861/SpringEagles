package com.ohgiraffers.springeagles.kkhBlog.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KHLikesRepository extends JpaRepository<KHLikesEntity, Integer> {
}
