package com.ohgiraffers.springeagles.jstBlog.userIntro.service;

import com.ohgiraffers.springeagles.jstBlog.userIntro.model.UserIntroDTO;
import com.ohgiraffers.springeagles.jstBlog.userIntro.entity.UserIntroEntity;
import com.ohgiraffers.springeagles.jstBlog.userIntro.repository.UserIntroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserIntroService {

    private final UserIntroRepository userIntroRepository;

    @Autowired
    public UserIntroService(UserIntroRepository userIntroRepository) {
        this.userIntroRepository = userIntroRepository;
    }

    @Transactional
    public Integer saveOrUpdateIntroContent(UserIntroDTO userIntroDTO) {
        if (userIntroDTO.getIntroContent() == null || userIntroDTO.getIntroContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Intro content cannot be null or empty");
        }

        Optional<UserIntroEntity> optionalIntroEntity = userIntroRepository.findById(1);
        UserIntroEntity entity;
        if (optionalIntroEntity.isPresent()) {
            entity = optionalIntroEntity.get();
            entity.setIntroContent(userIntroDTO.getIntroContent());
            userIntroRepository.save(entity);
            return 2; // 수정 완료
        } else {
            entity = new UserIntroEntity();
            entity.setIntroContent(userIntroDTO.getIntroContent());
            userIntroRepository.save(entity);
            return 1; // 저장 완료
        }
    }

    public Optional<String> getIntroContent() {
        Optional<UserIntroEntity> optionalIntroEntity = userIntroRepository.findById(1);
        return optionalIntroEntity.map(UserIntroEntity::getIntroContent);
    }
}