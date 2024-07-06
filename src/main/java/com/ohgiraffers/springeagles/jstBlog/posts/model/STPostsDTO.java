package com.ohgiraffers.springeagles.jstBlog.posts.model;

import com.ohgiraffers.springeagles.jstBlog.likes.entity.STLikesEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.entity.STPostsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private List<String> tagArray;
    private int likesCount;
    private List<STLikesEntity> likes;

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
        this.tagArray = entity.getTagArray();
        this.likesCount = entity.getLikesCount();
        this.likes = entity.getLikes();
    }
}
