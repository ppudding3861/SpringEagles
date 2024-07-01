package com.ohgiraffers.springeagles.jstBlog.posts.dto;

import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor // 기본 생성자를 생성
@ToString // toString 메소드를 생성
public class STPostsDTO {

    private Integer postId;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Integer commentId;
    private Integer userId;
    private Integer likesId;
    private List<String> tagArray;

    // Entity -> DTO
    public STPostsDTO(STPostsEntity entity) {
        this.postId = entity.getPostId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
        this.commentId = entity.getCommentId();
        this.userId = entity.getUserId();
        this.likesId = entity.getLikesId();
        this.tagArray = entity.getTagArray();
    }
}
