package com.ohgiraffers.springeagles.jstBlog.likes.entity;

import com.ohgiraffers.springeagles.jstBlog.posts.entity.STPostsEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "st_likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class STLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id", nullable = false)
    private Integer likesId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private STPostsEntity post;
}
