package com.ohgiraffers.springeagles.lshBlog.comment.service;

import com.ohgiraffers.springeagles.lshBlog.comment.model.dto.SHCommentDTO;
import com.ohgiraffers.springeagles.lshBlog.comment.model.entity.SHCommentEntity;
import com.ohgiraffers.springeagles.lshBlog.comment.repository.SHCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SHCommentService {

    private final SHCommentRepository SHCommentRepository;

    @Autowired
    public SHCommentService(SHCommentRepository SHCommentRepository) {
        this.SHCommentRepository = SHCommentRepository;
    }

    @Transactional
    public int comment(SHCommentDTO SHCommentDTO) {
        List<SHCommentEntity> SHCommentEntities = SHCommentRepository.findAll();
        // 도메인 로직
        for (SHCommentEntity blog : SHCommentEntities) {
            if(blog.getCommentContent().equals(SHCommentDTO.getCommentContent())){
                return 0;
            }
        }

        SHCommentEntity saveBlog = new SHCommentEntity();
        saveBlog.setCommentContent(SHCommentDTO.getCommentContent());
        saveBlog.setCommentAuthor(SHCommentDTO.getCommentAuthor());
        saveBlog.setCreatedDate(LocalDateTime.now());
        SHCommentEntity result  = SHCommentRepository.save(saveBlog);

        int resultValue = 0;

        if(result != null){
            resultValue = 1;
        }

        return resultValue;
    }
}
