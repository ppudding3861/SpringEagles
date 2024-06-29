package com.ohgiraffers.springeagles.jstBlog.comment.service;

import com.ohgiraffers.springeagles.global.error.ResourceNotFoundException;
import com.ohgiraffers.springeagles.jstBlog.comment.dto.STCommentDTO;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentRepository;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class STCommentService {

    private final STCommentRepository STCommentRepository;
    private final STPostsRepository STPostsRepository;

    // CommentService 생성자
    @Autowired
    public STCommentService(STCommentRepository STCommentRepository, STPostsRepository STPostsRepository) {
        this.STCommentRepository = STCommentRepository;
        this.STPostsRepository = STPostsRepository;
    }

}
