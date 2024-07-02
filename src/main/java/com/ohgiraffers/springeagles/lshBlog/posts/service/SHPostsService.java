package com.ohgiraffers.springeagles.lshBlog.posts.service;

import com.ohgiraffers.springeagles.lshBlog.posts.repository.SHPostsRepository;
import com.ohgiraffers.springeagles.lshBlog.posts.model.dto.SHPostsDTO;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
   public List<SHPostsEntity> postsEntityList(){
        List<SHPostsEntity> postlist = SHPostsRepository.findAll();
        return postlist;
   }

    public int post(SHPostsDTO SHPostsDTO) {
        List<SHPostsEntity> SHPostsEntities = SHPostsRepository.findAll();
        // 도메인 로직
        for (SHPostsEntity posts: SHPostsEntities) {
            if(posts.getTitle().equals(SHPostsDTO.getTitle())){
                return 0;
            }
        }

        SHPostsEntity postSave = new SHPostsEntity();
        postSave.setContents(SHPostsDTO.getContents());
        postSave.setTitle(SHPostsDTO.getTitle());
        postSave.setCreatedAt(LocalDateTime.now());
        SHPostsEntity result  = SHPostsRepository.save(postSave);

        int resultValue = 0;

        if(result != null){
            resultValue = 1;
        }

        return resultValue;
    }

    public List<SHPostsEntity> getAllPosts() {
        return SHPostsRepository.findAll();
    }
}
