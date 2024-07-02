package com.ohgiraffers.springeagles.lshBlog.posts.model.entity;

import com.ohgiraffers.springeagles.lshBlog.comment.model.entity.SHCommentEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sh_posts")
public class SHPostsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Interger랑 차이는 뭐지?

    @Column(name = "sh_title", unique = true, nullable = false)
    private String title;

    @Column(name = "sh_contents", nullable = false, length = 5000)
    private String contents;

    @Column(name = "sh_image_url")
    private String imageUrl;

    @Column(name = "sh_tag_array")
    private String tagArrayAsString;

    @Column(name = "sh_likes_count")
    private int likesCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postsEntity")
    private List<SHCommentEntity> comments;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // 작성일?
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public SHPostsEntity() {
    }

    public SHPostsEntity(int id, String title, String contents, String imageUrl, String tagArrayAsString, int likesCount, List<SHCommentEntity> comments, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.imageUrl = imageUrl;
        this.tagArrayAsString = tagArrayAsString;
        this.likesCount = likesCount;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public int getId() {
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

    public String getTagArrayAsString() {
        return tagArrayAsString;
    }

    public void setTagArrayAsString(String tagArrayAsString) {
        this.tagArrayAsString = tagArrayAsString;
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
                ", tagArrayAsString='" + tagArrayAsString + '\'' +
                ", likesCount=" + likesCount +
                ", comments=" + comments +
                ", createdAt=" + createdAt +
                '}';
    }
}
