package com.ohgiraffers.springeagles.jstBlog.userIntro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserIntroRepository extends JpaRepository<UserIntroEntity, Integer> {

}