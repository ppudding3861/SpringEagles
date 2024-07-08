package com.ohgiraffers.springeagles.hjhBlog.posts.service;


import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class JHPostsService {

    private final JHPostsRepository jhPostsRepository;


    @Autowired
    public JHPostsService(JHPostsRepository jhPostsRepository) {
        this.jhPostsRepository = jhPostsRepository;

    }

    // Read
    // 모든 게시물을 조회합니다.
    public List<JHPostsEntity> getAllPosts() {
        return jhPostsRepository.findAll(); // 모든 게시물을 반환합니다.
    }


    public Integer add(JHPostsDTO jhPostsDTO) {

        JHPostsEntity entity = new JHPostsEntity();
        entity.setPostId(jhPostsDTO.getPostId());
        entity.setTitle(jhPostsDTO.getTitle());
        entity.setDescription(jhPostsDTO.getDescription());
        entity.setContent(jhPostsDTO.getContent());
        entity.setImageUrl(jhPostsDTO.getImageUrl());

        JHPostsEntity result = jhPostsRepository.save(entity);

        if(Objects.isNull(result)){
            return 0;
        }else{
            return 1;
        }

    }

    public List<JHPostsEntity> postsEntityList() {
        List<JHPostsEntity> postlist = jhPostsRepository.findAll();

        return postlist;
    }


    // ID를 통해 특정 게시글을 가져오는 메서드
    public Optional<JHPostsEntity> getPostById(Integer id) {

        return jhPostsRepository.findById(id); // ID로 게시글을 데이터베이스에서 조회하여 반환
    }
}
