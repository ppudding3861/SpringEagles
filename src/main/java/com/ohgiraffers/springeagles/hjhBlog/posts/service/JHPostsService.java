package com.ohgiraffers.springeagles.hjhBlog.posts.service;

import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class JHPostsService {

    private final JHPostsRepository postsRepository;

    @Autowired
    public JHPostsService(JHPostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    // 전체 포스트 리스트를 반환하는 메서드
    public List<JHPostsDTO> getAllPosts() {
        List<JHPostsEntity> postsEntities = postsRepository.findAll();
        return postsEntities.stream()
                .map(JHPostsDTO::new)  // PostsEntity를 PostsDTO로 변환
                .collect(Collectors.toList());
    }

    // 사이드 태그 리스트를 반환하는 메서드
    public Set<String> getSideTags(List<JHPostsDTO> postList) {
        return postList.stream()
                .flatMap(post -> Arrays.stream(post.getTagArray())) // 각 post의 tagArray를 스트림으로 변환
                .collect(Collectors.toSet()); // 중복을 제거하고 Set으로 변환하여 반환
    }

    // 포스트 저장 메서드
    public void savePost(JHPostsDTO postsDTO) {
        if (postsDTO == null) {
            throw new IllegalArgumentException("PostsDTO must not be null");
        }

        JHPostsEntity postsEntity = new JHPostsEntity(postsDTO);

        postsRepository.save(postsEntity);
    }
}
