package com.ohgiraffers.springeagles.sejBlog.posts.repository;

import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EJPostsRepository extends JpaRepository<EJPostsEntity, Integer> {
}
