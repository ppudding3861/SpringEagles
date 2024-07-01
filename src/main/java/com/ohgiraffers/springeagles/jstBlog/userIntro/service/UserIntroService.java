package com.ohgiraffers.springeagles.jstBlog.userIntro.service;

import com.ohgiraffers.springeagles.jstBlog.userIntro.repository.UserIntroEntity;
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
    public void saveOrUpdateIntroContent(String userIntroContent) {
        try {
            Optional<UserIntroEntity> existingIntro = userIntroRepository.findById(1); // 예시로 사용자 ID가 1인 경우를 가정합니다.

            if (existingIntro.isPresent()) {
                // 기존 소개 내용 업데이트
                UserIntroEntity introEntity = existingIntro.get();
                introEntity.setIntroContent(userIntroContent);
                userIntroRepository.save(introEntity);
            } else {
                // 새로운 소개 내용 저장
                UserIntroEntity newIntroEntity = new UserIntroEntity();
                newIntroEntity.setIntroContent(userIntroContent);
                newIntroEntity.setIntroId(1); // 예시로 사용자 ID를 1로 설정합니다.
                userIntroRepository.save(newIntroEntity);
            }
        } catch (Exception e) {
            // 예외 처리 로직을 여기에 추가할 수 있습니다.
        }
    }

    public String getIntroContent() {
        Optional<UserIntroEntity> optionalIntroEntity = userIntroRepository.findById(1);
        if (optionalIntroEntity.isPresent()) {
            return optionalIntroEntity.get().getIntroContent();
        } else {
            return null; // or return a default value
        }
    }
}