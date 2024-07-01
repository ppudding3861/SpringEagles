package com.ohgiraffers.springeagles.global.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserName(String username);
    Optional<UserEntity> findByUserPassword(String userPassword);
    Optional<UserEntity> findByUserEmail(String userEmail);
}
