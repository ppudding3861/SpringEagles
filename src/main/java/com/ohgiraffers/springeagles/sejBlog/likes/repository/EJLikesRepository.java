package com.ohgiraffers.springeagles.sejBlog.likes.repository;

import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EJLikesRepository extends JpaRepository<EJPostsEntity, Integer> {
}
