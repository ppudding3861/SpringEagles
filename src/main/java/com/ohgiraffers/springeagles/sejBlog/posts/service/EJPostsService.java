package com.ohgiraffers.springeagles.sejBlog.posts.service;

import com.ohgiraffers.springeagles.sejBlog.posts.dto.EJPostsDTO;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EJPostsService {

    private final com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsRepository EJPostsRepository;

    @Autowired
    public EJPostsService(EJPostsRepository EJPostsRepository) {
        this.EJPostsRepository = EJPostsRepository;
    }

    // 전체 포스트 리스트를 반환하는 메서드
    public List<EJPostsDTO> getAllPosts() {
        List<EJPostsEntity> postsEntities = EJPostsRepository.findAll();
        return postsEntities.stream()
                .map(EJPostsDTO::new)  // PostsEntity를 PostsDTO로 변환
                .collect(Collectors.toList());
    }

    // 사이드 태그 리스트를 반환하는 메서드
    public Set<String> getSideTags(List<EJPostsDTO> postList) {
        return postList.stream()
                .flatMap(post -> Arrays.stream(post.getTagArray())) // 각 post의 tagArray를 스트림으로 변환
                .collect(Collectors.toSet()); // 중복을 제거하고 Set으로 변환하여 반환
    }

    // 포스트 저장 메서드
    public void savePost(EJPostsDTO EJPostsDTO) {
        if (EJPostsDTO == null) {
            throw new IllegalArgumentException("PostsDTO must not be null");
        }

        EJPostsEntity EJPostsEntity = new EJPostsEntity(EJPostsDTO);

        EJPostsRepository.save(EJPostsEntity);
    }
}
