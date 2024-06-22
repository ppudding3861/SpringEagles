package com.ohgiraffers.springeagles.common;

import java.util.Date;
import java.util.List;

public class PostSaveDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private Date createdAt;
    private List<String> tagArray;
    private int commentsCount;
    private int likesCount;

    public PostSaveDTO() {
        this.createdAt = new Date();
    }

    public PostSaveDTO(Long id, String title, String description, String imageUrl, String content, Date createdAt, List<String> tagArray, int commentsCount, int likesCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.createdAt = createdAt;
        this.tagArray = tagArray;
        this.commentsCount = commentsCount;
        this.likesCount = likesCount;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getTagArray() {
        return tagArray;
    }

    public void setTagArray(List<String> tagArray) {
        this.tagArray = tagArray;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    @Override
    public String toString() {
        return "PostSaveDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", tagArray=" + tagArray +
                ", commentsCount=" + commentsCount +
                ", likesCount=" + likesCount +
                '}';
    }
}
