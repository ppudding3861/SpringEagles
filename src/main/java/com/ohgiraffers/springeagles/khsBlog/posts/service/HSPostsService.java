package com.ohgiraffers.springeagles.khsBlog.posts.service;

import com.ohgiraffers.springeagles.khsBlog.posts.dto.HSPostsDTO;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// HSPostsService 클래스는 비즈니스 로직을 담당하는 서비스 클래스입니다.
@Service
public class HSPostsService {

    private HSPostsRepository hsPostsRepository; // HSPostsRepository 인스턴스 주입을 위한 필드

    // 생성자를 통한 의존성 주입
    @Autowired
    public HSPostsService(HSPostsRepository hsPostsRepository) {
        this.hsPostsRepository = hsPostsRepository;
    }

    @Transactional
    public int addPost(HSPostsDTO hsPostsDTO) {
        List<HSPostsEntity> hsPostsEntityList = hsPostsRepository.findAll();

        for (HSPostsEntity entity : hsPostsEntityList) {
            if(entity.getTitle().equals(hsPostsDTO.getTitle())){
                return 0;
            }
        }

        HSPostsEntity savedEntity = new HSPostsEntity();
        savedEntity.setTitle(hsPostsDTO.getTitle());
        savedEntity.setDescription(hsPostsDTO.getDescription());
        savedEntity.setContent(hsPostsDTO.getContent());
        savedEntity.setImageUrl(hsPostsDTO.getImageUrl());
        savedEntity.setCategory(hsPostsDTO.getCategory());

        HSPostsEntity result = hsPostsRepository.save(savedEntity);

        return result != null ? 1 : 0;

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
    public void deletePost(Integer id) {
        hsPostsRepository.deleteById(id); // ID로 게시글을 데이터베이스에서 삭제
    }

    // ID를 통해 특정 게시글을 수정하는 메서드
    @Transactional
    public void modifypost(Integer id, HSPostsDTO hsPostsDTO) {
        // ID로 게시글을 조회하고, 없을 경우 예외를 발생시킴
        HSPostsEntity hsPostsEntity = hsPostsRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 수정 실패: 아이디를 찾을 수 없습니다."); // 예외 메시지
        });
        // 요청된 게시글의 필드 값으로 기존 게시글의 필드 값을 업데이트
        hsPostsEntity.setTitle(hsPostsDTO.getTitle()); // 제목 수정
        hsPostsEntity.setDescription(hsPostsDTO.getDescription()); // 설명 수정
        hsPostsEntity.setContent(hsPostsDTO.getContent()); // 내용 수정
        hsPostsEntity.setImageUrl(hsPostsDTO.getImageUrl()); // 이미지 URL 수정
        hsPostsEntity.setCategory(hsPostsDTO.getCategory()); // 카테고리 수정
        hsPostsRepository.save(hsPostsEntity);
    }
    @Transactional
    public List<HSPostsEntity> searchPosts(String keyword){
        List<HSPostsEntity> postList = postsEntityList();
        if (keyword != null && !keyword.isEmpty()){
            return postList.stream()
                    .filter(post -> post.getTitle().contains(keyword)
                            || post.getDescription().contains(keyword)
                            || post.getContent().contains(keyword))
                    .collect(Collectors.toList());
        }else {
            return Collections.emptyList();
        }
    }
}