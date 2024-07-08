package com.ohgiraffers.springeagles.hjhBlog.posts.service;


import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsRepository;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<JHPostsEntity> postsEntityList() {
        List<JHPostsEntity> postlist = jhPostsRepository.findAll();

        return postlist;
    }

    public Optional<JHPostsEntity> getPostById(Integer id) {
        return jhPostsRepository.findById(id);
    }

    public void deletePost(Integer id) {
        jhPostsRepository.deleteById(id);
    }

    @Transactional
    public void modifypost(Integer id, JHPostsEntity requestpost){
        JHPostsEntity jhPostsEntity1 = jhPostsRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 수정 실패: 아이디를 찾을 수 없습니다.");
        });
        jhPostsEntity1.setTitle(requestpost.getTitle());
        jhPostsEntity1.setDescription(requestpost.getDescription());
        jhPostsEntity1.setContent(requestpost.getContent());
        jhPostsEntity1.setImageUrl(requestpost.getImageUrl());
    }
}
