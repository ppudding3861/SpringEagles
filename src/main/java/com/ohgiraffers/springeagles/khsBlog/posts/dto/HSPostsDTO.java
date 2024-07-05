package com.ohgiraffers.springeagles.khsBlog.posts.dto;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;

// HSPostsDTO 클래스는 데이터 전송 객체로, 클라이언트와 서버 간의 데이터 전송을 담당합니다.
public class HSPostsDTO {

    // 게시글의 고유 ID
    private Integer post_id;
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

    // 기본 생성자
    public HSPostsDTO() {
    }

    // 모든 필드를 초기화하는 생성자
    public HSPostsDTO(Integer post_id, String title, String description, String content, String imageUrl, String category) {
        this.post_id = post_id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    // DTO를 엔티티로 변환하는 메서드
    public HSPostsEntity toEntity() {
        return new HSPostsEntity(post_id, title, description, content, imageUrl, category);
    }

    // 수정된 엔티티 객체를 반환하는 메서드
    public HSPostsEntity toModify() {
        HSPostsEntity entity = new HSPostsEntity();
        entity.setPost_id(this.post_id); // 현재 DTO의 post_id로 설정
        entity.setTitle(this.title); // 현재 DTO의 title로 설정
        entity.setDescription(this.description); // 현재 DTO의 description으로 설정
        entity.setContent(this.content); // 현재 DTO의 content로 설정
        entity.setImageUrl(this.imageUrl); // 현재 DTO의 imageUrl로 설정
        entity.setCategory(this.category); // 현재 DTO의 category로 설정
        return entity;
    }

    // post_id의 Getter 메서드
    public Integer getPost_id() {
        return post_id;
    }

    // post_id의 Setter 메서드
    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    // title의 Getter 메서드
    public String getTitle() {
        return title;
    }

    // title의 Setter 메서드
    public void setTitle(String title) {
        this.title = title;
    }

    // description의 Getter 메서드
    public String getDescription() {
        return description;
    }

    // description의 Setter 메서드
    public void setDescription(String description) {
        this.description = description;
    }

    // content의 Getter 메서드
    public String getContent() {
        return content;
    }

    // content의 Setter 메서드
    public void setContent(String content) {
        this.content = content;
    }

    // imageUrl의 Getter 메서드
    public String getImageUrl() {
        return imageUrl;
    }

    // imageUrl의 Setter 메서드
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // category의 Getter 메서드
    public String getCategory() {
        return category;
    }

    // category의 Setter 메서드
    public void setCategory(String category) {
        this.category = category;
    }

    // 객체의 문자열 표현을 반환하는 메서드
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