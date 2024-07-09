package com.ohgiraffers.springeagles.khsBlog.posts.service;

import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HSPostsService {

    private HSPostsRepository hsPostsRepository;

    @Autowired
    public HSPostsService(HSPostsRepository hsPostsRepository) {
        this.hsPostsRepository = hsPostsRepository;
    }

    @Transactional
    public List<HSPostsEntity> postsEntityList() {

        List<HSPostsEntity> postlist = hsPostsRepository.findAll();
        return postlist;
    }

    @Transactional
    public Optional<HSPostsEntity> getPostById(Integer id) {
        return hsPostsRepository.findById(id);
    }

    @Transactional
    public void deletePost(Integer id) {
        hsPostsRepository.deleteById(id);
    }

    @Transactional
    public void modifypost(Integer id, HSPostsEntity requestpost){
        HSPostsEntity hsPostsEntity1 = hsPostsRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 수정 실패: 아이디를 찾을 수 없습니다.");
        });
        hsPostsEntity1.setTitle(requestpost.getTitle());
        hsPostsEntity1.setDescription(requestpost.getDescription());
        hsPostsEntity1.setContent(requestpost.getContent());
        hsPostsEntity1.setImageUrl(requestpost.getImageUrl());
        hsPostsEntity1.setCategory(requestpost.getCategory());
    }

}
