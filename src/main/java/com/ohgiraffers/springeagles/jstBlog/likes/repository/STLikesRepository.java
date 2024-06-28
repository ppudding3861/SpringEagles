package com.ohgiraffers.springeagles.jstBlog.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STLikesRepository extends JpaRepository<STLikesEntity, Integer> {
}
