package com.ohgiraffers.springeagles.jstBlog.posts.repository;

import com.ohgiraffers.springeagles.jstBlog.likes.repository.STLikesEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.dto.STPostsDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<STLikesEntity> likes = new ArrayList<>();

    @Column(name = "post_tags")
    @ElementCollection
    private List<String> tagArray;

    @Transient
    private int likesCount;

    public void addLike(STLikesEntity like) {
        this.likes.add(like);
        like.setPost(this);
    }

    public int getLikesCount() {
        return likes.size();
    }

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
        this.tagArray = dto.getTagArray();
        if (dto.getLikes() != null) {
            dto.getLikes().forEach(this::addLike);
        }
        this.likesCount = dto.getLikesCount();
    }
}
