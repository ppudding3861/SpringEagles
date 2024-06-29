package com.ohgiraffers.springeagles.global.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoy extends JpaRepository<UserEntity, Integer> {
}
