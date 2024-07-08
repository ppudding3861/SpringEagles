package com.ohgiraffers.springeagles.hjhBlog.posts.dto;

import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor // 기본 생성자를 생성
@ToString // toString 메소드를 생성
public class JHPostsDTO {

    private Integer postId;
    private String title;
    private String description;
    private String imageUrl;
    private String content;


    // Entity -> DTO
    public JHPostsDTO(JHPostsEntity entity) {
        this.postId = entity.getPostId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.content = entity.getContent();

    }

}
