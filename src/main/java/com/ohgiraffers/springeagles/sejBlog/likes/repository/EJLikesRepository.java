package com.ohgiraffers.springeagles.sejBlog.likes.repository;

import com.ohgiraffers.springeagles.sejBlog.likes.model.entity.EJLikesEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EJLikesRepository extends JpaRepository <EJLikesEntity, Integer> {
    List<EJLikesEntity> findByPosts(EJPostsEntity posts);
    // ejPostsEntity 는 Entity 클래스 선언한 이름고 동일해야 한다.

}
