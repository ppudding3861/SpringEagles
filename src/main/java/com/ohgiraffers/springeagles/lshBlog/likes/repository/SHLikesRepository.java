package com.ohgiraffers.springeagles.lshBlog.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SHLikesRepository extends JpaRepository<SHLikesEntity, Integer> {
}
