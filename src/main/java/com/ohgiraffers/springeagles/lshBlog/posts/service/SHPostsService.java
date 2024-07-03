package com.ohgiraffers.springeagles.lshBlog.posts.service;

import com.ohgiraffers.springeagles.lshBlog.posts.model.dto.SHPostsDTO;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import com.ohgiraffers.springeagles.lshBlog.posts.repository.SHPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Transactional
    public List<SHPostsEntity> postsEntityList(){
        List<SHPostsEntity> postlist = SHPostsRepository.findAll();
        List<SHPostsDTO> postDtoList = new ArrayList<>();

        for (SHPostsEntity shPostsEntity : postlist) {
            SHPostsDTO shPostsDto = SHPostsDTO.builder()
                    .id(shPostsEntity.getId())
                    .title(shPostsEntity.getTitle())
                    .contents(shPostsEntity.getContents())
                    .imageUrl(shPostsEntity.getImageUrl())
                    .createdAt(shPostsEntity.getCreatedAt())
                    .build();
            postDtoList.add(shPostsDto);
        }
        return postlist;
    }


    public List<SHPostsEntity> getAllPosts() {
        return SHPostsRepository.findAll();
    }
}
