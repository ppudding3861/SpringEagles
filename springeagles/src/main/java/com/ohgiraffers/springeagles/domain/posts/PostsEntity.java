package com.ohgiraffers.springeagles.domain.posts;

import com.ohgiraffers.springeagles.domain.comment.CommentEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "tag_array")
    private String tagArray;


    @Column(name = "likes_count")
    private int likesCount;

    // 일대다 관계: 하나의 포스트에 여러 댓글이 있을 수 있음
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postsEntity")
    private List<CommentEntity> comments = new ArrayList<>();

    public PostsEntity() {}

    public PostsEntity(Long id, String title, String description, String imageUrl, String content,
                       LocalDateTime createdAt, String tagArray, int likesCount,
                       List<CommentEntity> comments) {
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

    @Transient // 데이터베이스에 매핑하지 않음
    public int getCommentsCount() {
        return this.comments.size(); // comments 리스트의 사이즈를 반환
    }

    @Override
    public String toString() {
        return "PostsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", tagArray='" + tagArray + '\'' +
                ", likesCount=" + likesCount +
                ", comments=" + comments +
                '}';
    }
}
