
package com.ohgiraffers.springeagles.hjhBlog.likes.service;

import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import com.ohgiraffers.springeagles.global.auth.repository.UserRepository;
import com.ohgiraffers.springeagles.hjhBlog.likes.entity.JHLikesEntity;
import com.ohgiraffers.springeagles.hjhBlog.likes.repository.JHLikesRepository;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JHLikesService {

    private final JHLikesRepository jhLikesRepository;
    private final JHPostsRepository jhPostsRepository;
    private final UserRepository userRepository;

    @Autowired
    public JHLikesService(JHLikesRepository jhLikesRepository, JHPostsRepository jhPostsRepository, UserRepository userRepository) {
        this.jhLikesRepository = jhLikesRepository;
        this.jhPostsRepository = jhPostsRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void likePost(Integer postId, String username) {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을수 없습니다"));
        JHPostsEntity post = jhPostsRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을수 없습니다"));
        if (!jhLikesRepository.existsByPost_PostIdAndUserId(postId, user.getUserId())) {
            JHLikesEntity like = new JHLikesEntity();
            like.setPost(post);
            like.setUserId(user.getUserId());
            jhLikesRepository.save(like);
        }
    }

    @Transactional
    public void unlikePost(Integer postId, String username) {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        jhLikesRepository.deleteByPost_PostIdAndUserId(postId, user.getUserId());
    }

    public Map<Integer, Boolean> getLikeStatuses(Integer userId) {
        List<JHLikesEntity> likes = jhLikesRepository.findByUserId(userId);
        Map<Integer, Boolean> likeStatuses = new HashMap<>();
        for (JHLikesEntity like : likes) {
            likeStatuses.put(like.getPost().getPostId(), true);
        }
        return likeStatuses;
    }

    public int getLikesCountByPostId(Integer postId) {
        JHPostsEntity post = jhPostsRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        return jhLikesRepository.countByPost_PostId(post.getPostId());
    }
}
