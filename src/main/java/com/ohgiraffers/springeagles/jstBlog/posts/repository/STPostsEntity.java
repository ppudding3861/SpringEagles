package com.ohgiraffers.springeagles.jstBlog.posts.repository;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;
import java.time.LocalDate;

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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url")
    @Size(max = 255)
    private String imageUrl;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "likes_id")
    private Integer likesId;

}
