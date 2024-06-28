package com.ohgiraffers.springeagles.sejBlog.likes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EJLikesRepository extends JpaRepository<EJLikesEntity, Integer> {
}
