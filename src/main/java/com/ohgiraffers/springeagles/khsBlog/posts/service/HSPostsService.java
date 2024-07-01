package com.ohgiraffers.springeagles.khsBlog.posts.service;

import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
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

    public List<HSPostsEntity> postsEntityList() {

        List<HSPostsEntity> postlist = hsPostsRepository.findAll();
        return postlist;
    }

    public Optional<HSPostsEntity> getPostById(Integer id) {
        return hsPostsRepository.findById(id);
    }

}
