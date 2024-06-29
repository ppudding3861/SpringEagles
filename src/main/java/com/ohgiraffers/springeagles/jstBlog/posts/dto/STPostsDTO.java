package com.ohgiraffers.springeagles.jstBlog.posts.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor // 기본 생성자를 생성
@AllArgsConstructor
@ToString // toString 메소드를 생성
public class STPostsDTO {

    private Integer postId;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private LocalDate createdAt;
    private Integer likesId;
    private Integer commentId;
    private Integer userId;
}
