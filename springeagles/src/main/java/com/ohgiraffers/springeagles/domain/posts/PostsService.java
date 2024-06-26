package com.ohgiraffers.springeagles.domain.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    /**
     * 새로운 게시글을 데이터베이스에 저장합니다.
     * @param postsDTO 게시글 정보를 담고 있는 데이터 전송 객체(DTO)입니다.
     */
    public void savePost(PostsDTO postsDTO) {
        // PostsDTO를 PostsEntity로 변환합니다.
        PostsEntity entity = postsDTO.toEntity();

        // 변환된 엔티티를 데이터베이스에 저장합니다.
        postsRepository.save(entity);
    }
}