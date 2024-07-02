package com.ohgiraffers.springeagles.sejBlog.comment.service;

import com.ohgiraffers.springeagles.sejBlog.comment.model.dto.EJCommentDTO;
import com.ohgiraffers.springeagles.sejBlog.comment.model.entity.EJCommentEntity;
import com.ohgiraffers.springeagles.sejBlog.comment.repository.EJCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EJCommentService {

    private final EJCommentRepository EJCommentRepository;

    @Autowired
    public EJCommentService(EJCommentRepository EJCommentRepository) {
        this.EJCommentRepository = EJCommentRepository;
    }

    @Transactional
    public int comment(EJCommentDTO EJCommentDTO) {
        List<EJCommentEntity> EJCommentEntities = EJCommentRepository.findAll();
        // 도메인 로직
        for (EJCommentEntity blog : EJCommentEntities) {
            if(blog.getCommentContent().equals(EJCommentDTO.getCommentContent())){
                return 0;
            }
        }

        EJCommentEntity saveBlog = new EJCommentEntity();
        saveBlog.setCommentContent(EJCommentDTO.getCommentContent());
        saveBlog.setCommentAuthor(EJCommentDTO.getCommentAuthor());
        saveBlog.setCreatedDate(LocalDateTime.now());
        EJCommentEntity result  = EJCommentRepository.save(saveBlog);

        int resultValue = 0;

        if(result != null){
            resultValue = 1;
        }

        return resultValue;
    }
}
