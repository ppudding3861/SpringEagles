package com.ohgiraffers.springeagles.khsBlog.comment.service;

import com.ohgiraffers.springeagles.khsBlog.comment.entity.HSCommentEntity;
import com.ohgiraffers.springeagles.khsBlog.comment.model.HSCommentDTO;
import com.ohgiraffers.springeagles.khsBlog.comment.repository.CommentRepository;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final HSPostsRepository postRepository;

    @Transactional
    public HSCommentDTO createComment(Long postId, HSCommentDTO commentDTO) {
        Integer postIdAsInteger = postId.intValue();
        Optional<HSPostsEntity> byId = postRepository.findById(postIdAsInteger);
        HSPostsEntity post = byId.orElseThrow(() -> new PostNotFound("게시물이 삭제되었거나 존재하지 않습니다."));

        HSCommentEntity comment = HSCommentEntity.builder()
                .contents(commentDTO.getContents())
                .build();

        comment.mappingPost(post);
        HSCommentEntity saveComment = commentRepository.save(comment);

        return HSCommentDTO.convertToCommentDto(saveComment);
    }
}
