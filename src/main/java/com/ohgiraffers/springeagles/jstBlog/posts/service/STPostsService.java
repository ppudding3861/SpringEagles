package com.ohgiraffers.springeagles.jstBlog.posts.service;

import com.ohgiraffers.springeagles.jstBlog.posts.dto.STPostsDTO;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class STPostsService {

    private final STPostsRepository STPostsRepository;

    @Autowired
    public STPostsService(STPostsRepository STPostsRepository) {
        this.STPostsRepository = STPostsRepository;
    }

    // 전체 포스트 리스트를 반환하는 메서드
    public List<STPostsDTO> getAllPosts() {
        List<STPostsEntity> postsEntities = STPostsRepository.findAll();
        return postsEntities.stream()
                .map(STPostsDTO::new)  // PostsEntity를 PostsDTO로 변환
                .collect(Collectors.toList());
    }

    // 사이드 태그 리스트를 반환하는 메서드
    public Set<String> getSideTags(List<STPostsDTO> postList) {
        return postList.stream()
                .flatMap(post -> Arrays.stream(post.getTagArray())) // 각 post의 tagArray를 스트림으로 변환
                .collect(Collectors.toSet()); // 중복을 제거하고 Set으로 변환하여 반환
    }

    // 포스트 저장 메서드
    public void savePost(STPostsDTO STPostsDTO) {
        if (STPostsDTO == null) {
            throw new IllegalArgumentException("PostsDTO must not be null");
        }

        STPostsEntity STPostsEntity = new STPostsEntity(STPostsDTO);

        STPostsRepository.save(STPostsEntity);
    }
}
