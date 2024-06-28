package com.ohgiraffers.springeagles.kkhBlog.posts.service;

import com.ohgiraffers.springeagles.kkhBlog.posts.dto.KHPostsDTO;
import com.ohgiraffers.springeagles.kkhBlog.posts.repository.KHPostsEntity;
import com.ohgiraffers.springeagles.kkhBlog.posts.repository.KHPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class KHPostsService {

    private final KHPostsRepository KHPostsRepository;

    @Autowired
    public KHPostsService(KHPostsRepository KHPostsRepository) {
        this.KHPostsRepository = KHPostsRepository;
    }

    // 전체 포스트 리스트를 반환하는 메서드
    public List<KHPostsDTO> getAllPosts() {
        List<KHPostsEntity> postsEntities = KHPostsRepository.findAll();
        return postsEntities.stream()
                .map(KHPostsDTO::new)  // PostsEntity를 PostsDTO로 변환
                .collect(Collectors.toList());
    }

    // 사이드 태그 리스트를 반환하는 메서드
    public Set<String> getSideTags(List<KHPostsDTO> postList) {
        return postList.stream()
                .flatMap(post -> Arrays.stream(post.getTagArray())) // 각 post의 tagArray를 스트림으로 변환
                .collect(Collectors.toSet()); // 중복을 제거하고 Set으로 변환하여 반환
    }

    // 포스트 저장 메서드
    public void savePost(KHPostsDTO KHPostsDTO) {
        if (KHPostsDTO == null) {
            throw new IllegalArgumentException("PostsDTO must not be null");
        }

        KHPostsEntity KHPostsEntity = new KHPostsEntity(KHPostsDTO);

        KHPostsRepository.save(KHPostsEntity);
    }
}
