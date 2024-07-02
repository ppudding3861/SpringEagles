package com.ohgiraffers.springeagles.sejBlog.posts.service;

import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EJPostsService {

    private final EJPostsRepository EJPostsRepository;

    @Autowired
    public EJPostsService(EJPostsRepository EJPostsRepository) {

        this.EJPostsRepository = EJPostsRepository;
    }

   @Transactional
   public List<EJPostsEntity> postsEntityList(){
        List<EJPostsEntity> postlist = EJPostsRepository.findAll();
        return postlist;
   }


    public List<EJPostsEntity> getAllPosts() {
        return EJPostsRepository.findAll();
    }
}
