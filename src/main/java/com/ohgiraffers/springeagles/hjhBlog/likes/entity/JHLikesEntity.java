package com.ohgiraffers.springeagles.hjhBlog.likes.entity;

import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jh_likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JHLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id", nullable = false)
    private Integer likesId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private JHPostsEntity post;
}
