package com.ohgiraffers.springeagles.khsBlog.posts.dto;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;


public class HSPostsDTO {

    private Integer post_id;
    private String title;
    private String description;
    private String content;
    private String imageUrl;
    private String category;


    public HSPostsDTO() {
    }

    public HSPostsDTO(Integer post_id, String title, String description, String content, String imageUrl, String category) {
        this.post_id = post_id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
    }


    public HSPostsEntity toEntity() {

        return new HSPostsEntity(post_id, title, description, content, imageUrl, category);
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
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
                "post_id=" + post_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
