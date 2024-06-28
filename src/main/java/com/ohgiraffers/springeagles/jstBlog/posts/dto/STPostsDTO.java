package com.ohgiraffers.springeagles.jstBlog.posts.dto;

import com.ohgiraffers.springeagles.jstBlog.comment.dto.STCommentDTO;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class STPostsDTO {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private LocalDateTime createdAt;
    private String tagArrayAsString;
    private int likesCount;
    private List<STCommentDTO> comments;
    private int commentsCount;

    public STPostsDTO() {}

    public STPostsDTO(Long id, String title, String description, String imageUrl, String content,
                      LocalDateTime createdAt, String tagArrayAsString, int likesCount, List<STCommentDTO> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.createdAt = createdAt;
        this.tagArrayAsString = tagArrayAsString;
        this.likesCount = likesCount;
        this.comments = comments;
        this.commentsCount = comments != null ? comments.size() : 0; // 코멘트의 개수로 commentsCount를 설정
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

    public String[] getTagArray() {
        return tagArrayAsString != null ? tagArrayAsString.split(",") : new String[0];
    }

    public void setTagArray(String[] tagArray) {
        this.tagArrayAsString = String.join(",", tagArray);
    }


    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<STCommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<STCommentDTO> comments) {
        this.comments = comments;
        this.commentsCount = comments != null ? comments.size() : 0; // 코멘트의 개수로 commentsCount를 업데이트
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    // Entity to DTO constructor
    public STPostsDTO(STPostsEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.tagArrayAsString = Arrays.toString(entity.getTagArray());
        this.likesCount = entity.getLikesCount();
        this.comments = entity.getComments().stream()
                .map(STCommentDTO::fromEntity)
                .collect(Collectors.toList());
        this.commentsCount = this.comments.size(); // 코멘트의 개수로 commentsCount를 설정
    }

    private String convertTagArrayToString(String[] tagArray) {
        if (tagArray == null || tagArray.length == 0) {
            return "";
        }
        return String.join(",", tagArray);
    }

    // Helper method to convert tagArrayAsString to String array
    private String[] convertStringToTagArray(String tagArrayAsString) {
        if (tagArrayAsString == null || tagArrayAsString.isEmpty()) {
            return new String[0];
        }
        return tagArrayAsString.split(",");
    }

    // DTO를 Entity로 변환
    public STPostsEntity toEntity() {
        return new STPostsEntity(this);
    }


}
