package com.ohgiraffers.springeagles.khsBlog.posts.dto;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;

// HSPostsDTO 클래스는 데이터 전송 객체로, 클라이언트와 서버 간의 데이터 전송을 담당합니다.
public class HSPostsDTO {

    // 게시글의 제목
    private String title;
    // 게시글의 간단한 설명
    private String description;
    // 게시글의 본문 내용
    private String content;
    // 게시글에 포함된 이미지의 URL
    private String imageUrl;
    // 게시글의 카테고리
    private String category;

    public HSPostsDTO() {
    }

    public HSPostsDTO(String title, String description, String content, String imageUrl, String category) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
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
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}