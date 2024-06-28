package com.ohgiraffers.springeagles.khsBlog.posts.service;

import com.ohgiraffers.springeagles.khsBlog.posts.dto.HSPostsDTO;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class HSPostsService {

    private final HSPostsRepository hsPostsRepository;

    @Autowired
    public HSPostsService(HSPostsRepository hsPostsRepository) {
        this.hsPostsRepository = hsPostsRepository;
    }

    // 전체 포스트 리스트를 반환하는 메서드
    public List<HSPostsDTO> getAllPosts() {
        List<HSPostsEntity> postsEntities = hsPostsRepository.findAll();
        return postsEntities.stream()
                .map(HSPostsDTO::new)  // PostsEntity를 PostsDTO로 변환
                .collect(Collectors.toList());
    }

    // 사이드 태그 리스트를 반환하는 메서드
    public Set<String> getSideTags(List<HSPostsDTO> postList) {
        return postList.stream()
                .flatMap(post -> Arrays.stream(post.getTagArray())) // 각 post의 tagArray를 스트림으로 변환
                .collect(Collectors.toSet()); // 중복을 제거하고 Set으로 변환하여 반환
    }

    // 포스트 저장 메서드
    public void savePost(HSPostsDTO hsPostsDTO) {
        if (hsPostsDTO == null) {
            throw new IllegalArgumentException("PostsDTO must not be null");
        }

        HSPostsEntity hsPostsEntity = new HSPostsEntity(hsPostsDTO);

        hsPostsRepository.save(hsPostsEntity);
    }
}
