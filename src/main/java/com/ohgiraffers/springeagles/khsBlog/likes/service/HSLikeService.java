package com.ohgiraffers.springeagles.khsBlog.likes.service;

import com.ohgiraffers.springeagles.khsBlog.likes.entity.HSLikesEntity;
import com.ohgiraffers.springeagles.khsBlog.likes.repository.HSLikesRepository;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HSLikeService {

    private final HSLikesRepository likesRepository;
    private final HSPostsRepository postsRepository;

    @Autowired
    public HSLikeService(HSLikesRepository likesRepository, HSPostsRepository postsRepository) {
        this.likesRepository = likesRepository;
        this.postsRepository = postsRepository;
    }

    @Transactional
    public void likePost(Integer postId) {
        HSPostsEntity post = postsRepository.findById(postId).orElse(null);
        if (post != null) {
            HSLikesEntity likeEntity = likesRepository.findByPost(post);
            if (likeEntity == null) {
                likeEntity = new HSLikesEntity(post, 1);
            } else {
                likeEntity.setLikes(likeEntity.getLikes() + 1);
            }
            likesRepository.save(likeEntity);
        }
    }

    public Integer getLikes(Integer postId) {
        HSPostsEntity post = postsRepository.findById(postId).orElse(null);
        if (post != null) {
            HSLikesEntity likeEntity = likesRepository.findByPost(post);
            return likeEntity != null ? likeEntity.getLikes() : 0;
        }
        return 0;
    }
}
