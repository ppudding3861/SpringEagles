package com.ohgiraffers.springeagles.hjhBlog.posts.service;


import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class JHPostsService {

    private final JHPostsRepository jhPostsRepository;


    @Autowired
    public JHPostsService(JHPostsRepository jhPostsRepository) {
        this.jhPostsRepository = jhPostsRepository;

    }

    // Read
    // 모든 게시물을 조회합니다.
    public List<JHPostsEntity> getAllPosts() {
        return jhPostsRepository.findAll(); // 모든 게시물을 반환합니다.
    }


    public Integer add(JHPostsDTO jhPostsDTO) {

        JHPostsEntity entity = new JHPostsEntity();
        entity.setPostId(jhPostsDTO.getPostId());
        entity.setTitle(jhPostsDTO.getTitle());
        entity.setDescription(jhPostsDTO.getDescription());
        entity.setContent(jhPostsDTO.getContent());
        entity.setImageUrl(jhPostsDTO.getImageUrl());

        JHPostsEntity result = jhPostsRepository.save(entity);

        if(Objects.isNull(result)){
            return 0;
        }else{
            return 1;
        }

    }

//    public List<JHPostsEntity> postsEntityList() {
//        List<JHPostsEntity> postlist = jhPostsRepository.findAll();
//
//        return postlist;
//    }


    // ID를 통해 특정 게시글을 가져오는 메서드
    public Optional<JHPostsEntity> getPostById(Integer id) {

        return jhPostsRepository.findById(id); // ID로 게시글을 데이터베이스에서 조회하여 반환
    }

    // ID를 통해 특정 게시글을 삭제하는 메서드
    public void deletePost(Integer id) {
        jhPostsRepository.deleteById(id); // ID로 게시글을 데이터베이스에서 삭제
    }

    // ID를 통해 특정 게시글을 수정하는 메서드
    @Transactional
    public void modifypost(Integer id, JHPostsDTO jhPostsDTO) {
        // ID로 게시글을 조회하고, 없을 경우 예외를 발생시킴
        JHPostsEntity jhPostsEntity = jhPostsRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 수정 실패: 아이디를 찾을 수 없습니다."); // 예외 메시지
        });
        // 요청된 게시글의 필드 값으로 기존 게시글의 필드 값을 업데이트
        jhPostsEntity.setTitle(jhPostsDTO.getTitle()); // 제목 수정
        jhPostsEntity.setDescription(jhPostsDTO.getDescription()); // 설명 수정
        jhPostsEntity.setContent(jhPostsDTO.getContent()); // 내용 수정
        jhPostsEntity.setImageUrl(jhPostsDTO.getImageUrl()); // 이미지 URL 수정
        jhPostsRepository.save(jhPostsEntity);
    }
}
