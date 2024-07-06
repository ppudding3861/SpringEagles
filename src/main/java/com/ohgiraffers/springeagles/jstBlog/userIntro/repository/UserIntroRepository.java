package com.ohgiraffers.springeagles.jstBlog.userIntro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIntroRepository extends JpaRepository<UserIntroEntity, Integer> {

}