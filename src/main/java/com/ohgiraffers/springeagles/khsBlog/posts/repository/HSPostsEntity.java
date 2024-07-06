package com.ohgiraffers.springeagles.khsBlog.posts.repository;

import jakarta.persistence.*;

// HSPostsEntity 클래스는 데이터베이스의 hs_posts 테이블과 매핑되는 엔티티 클래스입니다.
@Entity
@Table(name = "hs_posts")
public class HSPostsEntity {

    // 게시글의 고유 ID로, 자동 생성됩니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;

    // 게시글의 제목으로, null이 될 수 없습니다.
    @Column(name = "title", nullable = false)
    private String title;

    // 게시글의 설명으로, null이 될 수 없습니다.
    @Column(name = "description", nullable = false)
    private String description;

    // 게시글의 내용으로, TEXT 타입을 사용하며 null이 될 수 없습니다.
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    // 게시글에 포함된 이미지의 URL로, null이 될 수 있습니다.
    @Column(name = "image_url")
    private String imageUrl;

    // 게시글의 카테고리로, null이 될 수 있습니다.
    @Column(name = "category")
    private String category;

    // 모든 필드를 초기화하는 생성자
    public HSPostsEntity(Integer post_id, String title, String description, String content, String imageUrl, String category) {
        this.post_id = post_id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    // 기본 생성자
    public HSPostsEntity() {
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
        return "HSPostsEntity{" +
                "post_id=" + post_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}