package com.ohgiraffers.springeagles.jstBlog.likes.service;

import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.global.user.repository.UserRepository;
import com.ohgiraffers.springeagles.jstBlog.likes.dto.STLikesDTO;
import com.ohgiraffers.springeagles.jstBlog.likes.repository.STLikesEntity;
import com.ohgiraffers.springeagles.jstBlog.likes.repository.STLikesRepository;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class STLikesService {

    private final STLikesRepository stLikesRepository;
    private final STPostsRepository stPostsRepository;
    private final UserRepository userRepository;

    @Autowired
    public STLikesService(STLikesRepository stLikesRepository, STPostsRepository stPostsRepository, UserRepository userRepository) {
        this.stLikesRepository = stLikesRepository;
        this.stPostsRepository = stPostsRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Integer likePost(STLikesDTO stLikesDTO, String username) {

        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을수 없습니다"));
        STPostsEntity post = stPostsRepository.findById(stLikesDTO.getPostId())
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을수 없습니다"));

        if (!stLikesRepository.existsByPost_PostIdAndUserId(stLikesDTO.getPostId(), user.getUserId())) {
            STLikesEntity like = new STLikesEntity();
            like.setPost(post);
            like.setUserId(user.getUserId());
            stLikesRepository.save(like);
            return 1; // 좋아요 성공 시 반환 값
        } else {
            return 0; // 이미 좋아요를 눌렀을 경우 반환 값
        }
    }

    @Transactional
    public Integer unlikePost(STLikesDTO stLikesDTO, String username) {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다"));

        STPostsEntity post = stPostsRepository.findById(stLikesDTO.getPostId())
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다"));

        if (stLikesRepository.existsByPost_PostIdAndUserId(stLikesDTO.getPostId(), user.getUserId())) {
            stLikesRepository.deleteByPost_PostIdAndUserId(stLikesDTO.getPostId(), user.getUserId());
            return 1; // 좋아요 취소 성공 시 반환 값
        } else {
            return 0; // 좋아요가 존재하지 않는 경우 반환 값
        }
    }


    public Map<Integer, Boolean> getLikeStatuses(Integer userId) {
        List<STLikesEntity> likes = stLikesRepository.findByUserId(userId);
        Map<Integer, Boolean> likeStatuses = new HashMap<>();
        for (STLikesEntity like : likes) {
            likeStatuses.put(like.getPost().getPostId(), true);
        }
        return likeStatuses;
    }

    public int getLikesCountByPostId(Integer postId) {
        STPostsEntity post = stPostsRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        return stLikesRepository.countByPost_PostId(post.getPostId());
    }
}
