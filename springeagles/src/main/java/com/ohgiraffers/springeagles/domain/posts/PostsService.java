package com.ohgiraffers.springeagles.domain.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    // 전체 포스트 리스트를 반환하는 메서드
    public List<PostsDTO> getAllPosts() {
        return postsRepository.findAll().stream()
                .map(PostsDTO::new)  // PostsEntity를 PostsDTO로 변환
                .collect(Collectors.toList());
    }

    // 사이드 태그 리스트를 반환하는 메서드
    public Set<String> getSideTags(List<PostsDTO> postList) {
        return postList.stream()
                .flatMap(post -> Arrays.stream(post.getTagArray().split(",")))
                .collect(Collectors.toSet());
    }

    // 포스트 저장 메서드
    public void savePost(PostsDTO postsDTO) {
        PostsEntity postsEntity = new PostsEntity(
                postsDTO.getId(),
                postsDTO.getTitle(),
                postsDTO.getDescription(),
                postsDTO.getImageUrl(),
                postsDTO.getContent(),
                postsDTO.getCreatedAt(),
                postsDTO.getTagArray(),
                postsDTO.getLikesCount(),
                postsDTO.getComments()
        );
        postsRepository.save(postsEntity);
    }
}
