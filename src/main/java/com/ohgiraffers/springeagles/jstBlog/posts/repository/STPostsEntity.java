package com.ohgiraffers.springeagles.jstBlog.posts.repository;

import com.ohgiraffers.springeagles.jstBlog.posts.dto.STPostsDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "st_posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class STPostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_description", nullable = false)
    private String description;

    @Column(name = "post_imageUrl", nullable = true, columnDefinition = "TINYTEXT")
    private String imageUrl;

    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "post_createdAt", nullable = false, updatable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    @Column(name = "post_updatedAt")
    private LocalDate updatedAt;

    @PreUpdate
    private void onUpdate() {
        updatedAt = LocalDate.now();
    }

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "likes_id")
    private Integer likesId;

    @Column(name = "post_tags")
    @ElementCollection
    private List<String> tagArray;

    // DTO -> Entity
    public STPostsEntity(STPostsDTO dto) {
        this.postId = dto.getPostId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.imageUrl = dto.getImageUrl();
        this.content = dto.getContent();
        this.createdAt = dto.getCreatedAt();
        this.updatedAt = dto.getUpdatedAt();
        this.userId = dto.getUserId();
        this.commentId = dto.getCommentId();
        this.likesId = dto.getLikesId();
        this.tagArray = dto.getTagArray();
    }
}
