package com.ohgiraffers.springeagles.jstBlog.comment.service;

import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import com.ohgiraffers.springeagles.global.auth.repository.UserRepository;
import com.ohgiraffers.springeagles.jstBlog.comment.model.STCommentDTO;
import com.ohgiraffers.springeagles.jstBlog.comment.entity.STCommentEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentRepository;
import com.ohgiraffers.springeagles.jstBlog.posts.entity.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        boolean isAuthorized = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN") || authority.getAuthority().equals("ROLE_JST"));

        if (!comment.getUserName().equals(currentUserName) && !isAuthorized) {
            throw new SecurityException("삭제 권한이 없습니다.");
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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        boolean isAuthorized = authorities.stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN") || authority.getAuthority().equals("ROLE_JST"));

        if (!comment.getUserName().equals(currentUserName) && !isAuthorized) {
            throw new SecurityException("수정 권한이 없습니다.");
        }

        comment.setCommentContent(stCommentDTO.getCommentContent());

        try {
            stCommentRepository.save(comment);
            System.out.println("댓글 수정 성공");
            return 1;
        } catch (Exception e) {
            System.out.println("댓글 수정 실패");
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
