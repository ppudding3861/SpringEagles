
package com.ohgiraffers.springeagles.jstBlog.likes.service;

import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import com.ohgiraffers.springeagles.global.auth.repository.UserRepository;
import com.ohgiraffers.springeagles.jstBlog.likes.entity.STLikesEntity;
import com.ohgiraffers.springeagles.jstBlog.likes.repository.STLikesRepository;
import com.ohgiraffers.springeagles.jstBlog.posts.entity.STPostsEntity;
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
    public void likePost(Integer postId, String username) {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을수 없습니다"));
        STPostsEntity post = stPostsRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을수 없습니다"));
        if (!stLikesRepository.existsByPost_PostIdAndUserId(postId, user.getUserId())) {
            STLikesEntity like = new STLikesEntity();
            like.setPost(post);
            like.setUserId(user.getUserId());
            stLikesRepository.save(like);
        }
    }

    @Transactional
    public void unlikePost(Integer postId, String username) {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        stLikesRepository.deleteByPost_PostIdAndUserId(postId, user.getUserId());
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
