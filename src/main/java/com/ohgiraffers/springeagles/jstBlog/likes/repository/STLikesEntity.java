package com.ohgiraffers.springeagles.jstBlog.likes.repository;

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

    @Column(name = "post_id", nullable = false)
    private Integer postId;
}
