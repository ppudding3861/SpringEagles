package com.ohgiraffers.springeagles.jstBlog.comment.service;

import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.global.user.repository.UserRepository;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentRepository;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class STCommentService {

    private final STCommentRepository STCommentRepository;
    private final STPostsRepository STPostsRepository;
    private final UserRepository userRepository;

    // CommentService 생성자
    @Autowired
    public STCommentService(STCommentRepository STCommentRepository, STPostsRepository STPostsRepository, UserRepository userRepository) {
        this.STCommentRepository = STCommentRepository;
        this.STPostsRepository = STPostsRepository;
        this.userRepository = userRepository;
    }

    public List<STCommentEntity> getCommentsByPost(Integer postId) {
        return STCommentRepository.findByPostId(postId);
    }

    public UserEntity getUserById(String userName) {
        return userRepository.findByUserName(userName).orElse(null);
    }

    public STPostsEntity getPostById(Integer postId) {
        return STPostsRepository.findById(postId).orElse(null);
    }

    public void saveComment(String userName, Integer postId, String commentContent) {

        STCommentEntity comment = new STCommentEntity();
        comment.setUserName(userName);
        comment.setPostId(postId);
        comment.setCommentContent(commentContent);

        // 댓글 저장
        STCommentRepository.save(comment);
    }

    public void deleteCommentById(Integer commentId) {
        STCommentEntity comment = STCommentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            STCommentRepository.delete(comment);
        }
    }
}
