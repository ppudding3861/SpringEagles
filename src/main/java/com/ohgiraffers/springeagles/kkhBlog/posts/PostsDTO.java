package com.ohgiraffers.springeagles.kkhBlog.posts;

import java.time.LocalDateTime;


public class PostsDTO {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private LocalDateTime createdAt;
    private String tagArrayAsString;
    private int likesCount;
    private int commentsCount;



}
