package com.ohgiraffers.springeagles.sejBlog.likes.service;

import com.ohgiraffers.springeagles.sejBlog.posts.model.dto.EJPostsDTO;
import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EJLikesService {

    private final EJPostsRepository eJPostsRepository;

    @Autowired
    public EJLikesService(EJPostsRepository eJPostsRepository) {
        this.eJPostsRepository = eJPostsRepository;
    }

    @Transactional
    public int post(EJPostsDTO EJPostsDTO) {
        List<EJPostsEntity> EJPostsEntities = eJPostsRepository.findAll();
        // 도메인 로직
        for (EJPostsEntity blog: EJPostsEntities) {
            if(blog.getTitle().equals(EJPostsDTO.getTitle())){
                return 0;
            }
        }

        EJPostsEntity saveBlog = new EJPostsEntity();
        saveBlog.setContents(EJPostsDTO.getContents());
        saveBlog.setTitle(EJPostsDTO.getTitle());
        saveBlog.setCreatedAt(LocalDateTime.now());
        EJPostsEntity result  = eJPostsRepository.save(saveBlog);

        int resultValue = 0;

        if(result != null){
            resultValue = 1;
        }

        return resultValue;
    }
}
