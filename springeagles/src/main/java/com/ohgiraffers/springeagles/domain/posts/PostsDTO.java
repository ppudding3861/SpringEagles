package com.ohgiraffers.springeagles.domain.posts;

import com.ohgiraffers.springeagles.domain.comment.CommentEntity;

import java.time.LocalDateTime;
import java.util.List;

public class PostsDTO {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private LocalDateTime createdAt;
    private String tagArray;
    private int likesCount;
    private List<CommentEntity> comments;

    public PostsDTO() {}

    public PostsDTO(Long id, String title, String description, String imageUrl, String content, LocalDateTime createdAt, String tagArray, int likesCount, List<CommentEntity> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.createdAt = createdAt;
        this.tagArray = tagArray;
        this.likesCount = likesCount;
        this.comments = comments;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTagArray() {
        return tagArray;
    }

    public void setTagArray(String tagArray) {
        this.tagArray = tagArray;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    // Entity to DTO constructor
    public PostsDTO(PostsEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.tagArray = entity.getTagArray();
        this.likesCount = entity.getLikesCount();
        this.comments = entity.getComments();
    }
}
