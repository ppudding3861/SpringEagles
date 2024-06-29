package com.ohgiraffers.springeagles.jstBlog.posts.service;

import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class STPostsService {

    private final STPostsRepository STPostsRepository;

    @Autowired
    public STPostsService(STPostsRepository STPostsRepository) {
        this.STPostsRepository = STPostsRepository;
    }

}
