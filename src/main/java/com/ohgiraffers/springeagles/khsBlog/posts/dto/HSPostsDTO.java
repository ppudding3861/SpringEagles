package com.ohgiraffers.springeagles.khsBlog.posts.dto;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;


public class HSPostsDTO {

    private Integer postId;
    private String title;
    private String description;
    private String content;
    private String imageUrl;
    private String category;


    public HSPostsDTO() {
    }

    public HSPostsDTO(Integer postId, String title, String description, String content, String imageUrl, String category) {
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
    }


    public HSPostsEntity toEntity() {

        return new HSPostsEntity(postId, title, description, content, imageUrl, category);

    }

    public HSPostsEntity toModify() {
        HSPostsEntity entity = new HSPostsEntity();
        entity.setPostId(this.postId);
        entity.setTitle(this.title);
        entity.setDescription(this.description);
        entity.setContent(this.content);
        entity.setImageUrl(this.imageUrl);
        entity.setCategory(this.category);
        return entity;
    }

    public Integer getPost_id() {
        return postId;
    }

    public void setPost_id(Integer post_id) {
        this.postId = post_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "HSPostsDTO{" +
                "post_id=" + postId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
