package com.ohgiraffers.springeagles.sejBlog.posts.service;

import com.ohgiraffers.springeagles.sejBlog.posts.model.dto.EJPostsDTO;
import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EJPostsService {

    private final EJPostsRepository ejPostsRepository;

    @Autowired
    public EJPostsService(EJPostsRepository ejPostsRepository) {
        this.ejPostsRepository = ejPostsRepository;
    }

    @Transactional
    public void savepost(EJPostsDTO ejPostsDTO) {
        EJPostsEntity ejPostsEntity = new EJPostsEntity();
        ejPostsEntity.setTitle(ejPostsDTO.getTitle());
        ejPostsEntity.setContents(ejPostsDTO.getContents());
        ejPostsRepository.save(ejPostsEntity);
    }

    @Transactional
    public List<EJPostsDTO> getallpost() {
        List<EJPostsEntity> ejPostsEntities = ejPostsRepository.findAll();
        List<EJPostsDTO> ejPostsDTOList = new ArrayList<>();
        for (EJPostsEntity ejPostsEntity : ejPostsEntities) {
            EJPostsDTO ejPostsDTO = new EJPostsDTO();
            ejPostsDTO.setId(ejPostsEntity.getId());
            ejPostsDTO.setTitle(ejPostsEntity.getTitle());
            ejPostsDTO.setContents(ejPostsEntity.getContents());
            ejPostsDTOList.add(ejPostsDTO);
        }
        return ejPostsDTOList;
    }
    // DTO id를 가져와서 Entity id 에 넣어준다
    @Transactional
    public EJPostsDTO getpost(Integer id) {
        EJPostsEntity ejPostsEntity = ejPostsRepository.findById(id).get();
        EJPostsDTO ejPostsDTO = new EJPostsDTO();
        ejPostsDTO.setId(ejPostsEntity.getId());
        ejPostsDTO.setTitle(ejPostsEntity.getTitle());
        ejPostsDTO.setContents(ejPostsEntity.getContents());
        return ejPostsDTO;
    }

    @Transactional
    public void updatePost(EJPostsDTO existingPost) {
        EJPostsEntity ejPostsEntity = ejPostsRepository.findById(existingPost.getId()).get();
        ejPostsEntity.setTitle(existingPost.getTitle());
        ejPostsEntity.setContents(existingPost.getContents());

        ejPostsRepository.save(ejPostsEntity);
    }

    @Transactional
    public void deletPost(Integer id) {
        ejPostsRepository.deleteById(id);
    }
}
