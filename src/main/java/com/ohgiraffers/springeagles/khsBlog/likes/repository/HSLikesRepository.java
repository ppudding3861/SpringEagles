package com.ohgiraffers.springeagles.khsBlog.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HSLikesRepository extends JpaRepository<HSLikesEntity, Integer> {
}
