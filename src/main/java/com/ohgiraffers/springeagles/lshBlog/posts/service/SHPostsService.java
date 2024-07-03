package com.ohgiraffers.springeagles.lshBlog.posts.service;

import com.ohgiraffers.springeagles.lshBlog.posts.model.dto.SHPostsDTO;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import com.ohgiraffers.springeagles.lshBlog.posts.repository.SHPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SHPostsService {

    private final SHPostsRepository SHPostsRepository;

    @Autowired
    public SHPostsService(SHPostsRepository SHPostsRepository) {
        this.SHPostsRepository = SHPostsRepository;
    }

    @Transactional
    public Integer save(SHPostsDTO shPostsDTO){
        System.out.println(shPostsDTO);
        System.out.println("-----------------------------------------------");
        SHPostsEntity entity = new SHPostsEntity();
        entity.setTitle(shPostsDTO.getTitle());
        entity.setContents(shPostsDTO.getContents());
        entity.setCreatedAt(LocalDateTime.now());

        SHPostsEntity savedEntity = SHPostsRepository.save(entity);
        return savedEntity.getId();
    }
    public List<SHPostsEntity> postsEntityList(){
        List<SHPostsEntity> postlist = SHPostsRepository.findAll();
        return postlist;
    }


    public List<SHPostsEntity> getAllPosts() {
        return SHPostsRepository.findAll();
    }
}
