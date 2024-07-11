package com.ohgiraffers.springeagles.global.auth.repository;

import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findByUserEmail(String userEmail);
    Optional<UserEntity> findUserIdByuserName(String username);
}
