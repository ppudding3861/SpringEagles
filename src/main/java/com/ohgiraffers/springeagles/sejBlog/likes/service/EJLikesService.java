package com.ohgiraffers.springeagles.sejBlog.likes.service;

import com.ohgiraffers.springeagles.sejBlog.likes.model.entity.EJLikesEntity;
import com.ohgiraffers.springeagles.sejBlog.likes.repository.EJLikesRepository;
import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EJLikesService {


    private final EJLikesRepository likesRepository;
    private final EJPostsRepository ejPostsRepository;

    @Autowired
    public EJLikesService(EJLikesRepository likesRepository, EJPostsRepository ejPostsRepository) {
        this.likesRepository = likesRepository;
        this.ejPostsRepository = ejPostsRepository;
    }

   @Transactional
    public void likePost(Integer postId) {
        EJPostsEntity ejPostsEntity = ejPostsRepository.findById(postId).orElse(null);
        List<EJLikesEntity> ejLikesEntities =likesRepository.findByPosts(ejPostsEntity);

        EJLikesEntity likesEntity;
        if(ejLikesEntities.isEmpty()) {
            likesEntity = new EJLikesEntity(ejPostsEntity, 1);

        } else {
            likesEntity = ejLikesEntities.get(0);
            likesEntity.setLikes(likesEntity.getLikes() + 1);
        }
        likesRepository.save(likesEntity);

    }

    public int getLikeCountByPostId(Integer postId) {

        EJPostsEntity ejPostsEntity = ejPostsRepository.findById(postId).orElse(null);
        List<EJLikesEntity> likesEntities =likesRepository.findByPosts(ejPostsEntity);
        if(likesEntities.isEmpty()) {
            return 0;
        }

        int result = likesEntities.get(0).getLikes();
        System.out.println(result);
        return result;

    }
}
