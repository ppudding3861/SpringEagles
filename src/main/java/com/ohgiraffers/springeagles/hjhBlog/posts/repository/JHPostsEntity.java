package com.ohgiraffers.springeagles.hjhBlog.posts.repository;

import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "jh_posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JHPostsEntity {

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


    // DTO -> Entity
    public JHPostsEntity(JHPostsDTO dto) {
        this.postId = dto.getPostId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.imageUrl = dto.getImageUrl();
        this.content = dto.getContent();

    }
}
