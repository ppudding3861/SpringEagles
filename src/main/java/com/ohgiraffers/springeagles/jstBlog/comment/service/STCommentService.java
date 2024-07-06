package com.ohgiraffers.springeagles.jstBlog.comment.service;

import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.global.user.repository.UserRepository;
import com.ohgiraffers.springeagles.jstBlog.comment.dto.STCommentDTO;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentRepository;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class STCommentService {

    private final STCommentRepository stCommentRepository;
    private final STPostsRepository stPostsRepository;
    private final UserRepository userRepository;

    // CommentService 생성자
    @Autowired
    public STCommentService(STCommentRepository stCommentRepository, STPostsRepository stPostsRepository,
                            UserRepository userRepository) {
        this.stCommentRepository = stCommentRepository;
        this.stPostsRepository = stPostsRepository;
        this.userRepository = userRepository;
    }

    // 댓글 저장
    @Transactional
    public Integer saveComment(STCommentDTO stCommentDTO) {
        // 요청 유효성 검증
        if (stCommentDTO == null || stCommentDTO.getUserName() == null || stCommentDTO.getPostId() == null || stCommentDTO.getCommentContent() == null) {
            return 0; // 유효하지 않은 요청
        }

        STCommentEntity comment = new STCommentEntity();
        comment.setUserName(stCommentDTO.getUserName());
        comment.setPostId(stCommentDTO.getPostId());
        comment.setCommentContent(stCommentDTO.getCommentContent());

        try {
            STCommentEntity result = stCommentRepository.save(comment);
            return result != null ? 1 : 0;
        } catch (Exception e) {
            // 예외 처리 로직 추가 (로그 등)
            return 0;
        }
    }

    // 댓글 삭제
    @Transactional
    public Integer deleteCommentById(STCommentDTO stCommentDTO) {
        // 요청 유효성 검증
        STCommentEntity comment = stCommentRepository.findById(stCommentDTO.getCommentId()).orElse(null);
        if (comment == null) {
            return 0; // 댓글이 존재하지 않음
        }
        try {
            stCommentRepository.delete(comment);
            return 1;
        } catch (Exception e) {
            // 예외 처리 로직 추가 (로그 등)
            return 0;
        }
    }

    // 댓글 수정
    @Transactional
    public Integer updateComment(STCommentDTO stCommentDTO) {
        // 요청 유효성 검증
        if (stCommentDTO.getCommentId() == null || stCommentDTO.getPostId() == null || stCommentDTO.getCommentContent() == null) {
            return 0; // 유효하지 않은 요청
        }
        STCommentEntity comment = stCommentRepository.findById(stCommentDTO.getCommentId())
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));
        comment.setCommentContent(stCommentDTO.getCommentContent());
        try {
            stCommentRepository.save(comment);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isCommentOwner(Integer commentId, String userName) {
        STCommentEntity comment = stCommentRepository.findById(commentId).orElse(null);
        return comment != null && comment.getUserName().equals(userName);
    }

    public List<STCommentEntity> getCommentsByPost(Integer postId) {
        return stCommentRepository.findByPostId(postId);
    }

    public UserEntity getUserById(String userName) {
        return userRepository.findByUserName(userName).orElse(null);
    }

    public STPostsEntity getPostById(Integer postId) {
        return stPostsRepository.findById(postId).orElse(null);
    }
}
