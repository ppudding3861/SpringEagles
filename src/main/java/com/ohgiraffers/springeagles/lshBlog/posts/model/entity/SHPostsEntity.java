package com.ohgiraffers.springeagles.lshBlog.posts.model.entity;

import com.ohgiraffers.springeagles.lshBlog.comment.model.entity.SHCommentEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(name = "sh_posts")
public class SHPostsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Interger랑 차이는 뭐지?

    @Column(name = "sh_title", unique = true, nullable = false)
    private String title;

    @Column(name = "sh_contents", nullable = false, length = 5000)
    private String contents;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "sh_image_url")
    private String imageUrl;

    @Column(name = "sh_likes_count")
    private int likesCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postsEntity")
    private List<SHCommentEntity> comments;

    // 작성일?
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @Builder
    public SHPostsEntity(int id, String title, String contents, LocalDateTime createdAt, String imageUrl, int likesCount) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.likesCount = likesCount;
    }

    public SHPostsEntity() {
    }

    public SHPostsEntity(int id, String title, String contents, String imageUrl, int likesCount, List<SHCommentEntity> comments, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.imageUrl = imageUrl;
        this.likesCount = likesCount;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<SHCommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<SHCommentEntity> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SHPostsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", likesCount=" + likesCount +
                ", comments=" + comments +
                ", createdAt=" + createdAt +
                '}';
    }
}
