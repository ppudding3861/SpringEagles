package com.ohgiraffers.springeagles.global.follow.repository;

import com.ohgiraffers.springeagles.global.follow.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<FollowEntity, Integer>{
}
