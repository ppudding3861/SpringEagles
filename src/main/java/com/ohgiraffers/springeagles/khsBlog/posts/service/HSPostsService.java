package com.ohgiraffers.springeagles.khsBlog.posts.service;

import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// HSPostsService 클래스는 비즈니스 로직을 담당하는 서비스 클래스입니다.
@Service
public class HSPostsService {

    private HSPostsRepository hsPostsRepository; // HSPostsRepository 인스턴스 주입을 위한 필드

    // 생성자를 통한 의존성 주입
    @Autowired
    public HSPostsService(HSPostsRepository hsPostsRepository) {
        this.hsPostsRepository = hsPostsRepository;
    }

    // 모든 게시글 목록을 가져오는 메서드
    public List<HSPostsEntity> postsEntityList() {
        List<HSPostsEntity> postlist = hsPostsRepository.findAll(); // 모든 게시글을 데이터베이스에서 조회
        return postlist; // 조회된 게시글 목록 반환
    }

    // ID를 통해 특정 게시글을 가져오는 메서드
    public Optional<HSPostsEntity> getPostById(Integer id) {
        return hsPostsRepository.findById(id); // ID로 게시글을 데이터베이스에서 조회하여 반환
    }

    // ID를 통해 특정 게시글을 삭제하는 메서드
    @Transactional
    public void deletePost(Integer id) {
        hsPostsRepository.deleteById(id); // ID로 게시글을 데이터베이스에서 삭제
    }

    // ID를 통해 특정 게시글을 수정하는 메서드
    @Transactional
    public void modifypost(Integer id, HSPostsEntity requestpost) {
        // ID로 게시글을 조회하고, 없을 경우 예외를 발생시킴
        HSPostsEntity hsPostsEntity1 = hsPostsRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 수정 실패: 아이디를 찾을 수 없습니다."); // 예외 메시지
        });
        // 요청된 게시글의 필드 값으로 기존 게시글의 필드 값을 업데이트
        hsPostsEntity1.setTitle(requestpost.getTitle()); // 제목 수정
        hsPostsEntity1.setDescription(requestpost.getDescription()); // 설명 수정
        hsPostsEntity1.setContent(requestpost.getContent()); // 내용 수정
        hsPostsEntity1.setImageUrl(requestpost.getImageUrl()); // 이미지 URL 수정
        hsPostsEntity1.setCategory(requestpost.getCategory()); // 카테고리 수정
    }
}