package com.ohgiraffers.springeagles.hjhBlog.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JHLikesRepository extends JpaRepository<JHLikesEntity, Integer> {
}
