package com.ohgiraffers.springeagles.lshBlog.likes.service;

import com.ohgiraffers.springeagles.lshBlog.posts.repository.SHPostsRepository;
import com.ohgiraffers.springeagles.lshBlog.posts.model.dto.SHPostsDTO;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class SHLikesService {

    private final SHPostsRepository SHPostsRepository;

    @Autowired
    public SHLikesService(SHPostsRepository SHPostsRepository) {
        this.SHPostsRepository = SHPostsRepository;
    }

    @Transactional
    public int post(SHPostsDTO SHPostsDTO) {
        List<SHPostsEntity> SHPostsEntities = SHPostsRepository.findAll();
        // 도메인 로직
        for (SHPostsEntity blog: SHPostsEntities) {
            if(blog.getTitle().equals(SHPostsDTO.getTitle())){
                return 0;
            }
        }

        SHPostsEntity saveBlog = new SHPostsEntity();
        saveBlog.setContents(SHPostsDTO.getContents());
        saveBlog.setTitle(SHPostsDTO.getTitle());
        saveBlog.setCreatedAt(LocalDateTime.now());
        SHPostsEntity result  = SHPostsRepository.save(saveBlog);

        int resultValue = 0;

        if(result != null){
            resultValue = 1;
        }

        return resultValue;
    }
}
