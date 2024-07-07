package com.ohgiraffers.springeagles.sejBlog.posts.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EJPostsDTO {

    private Integer id;
    private String title;
    private String contents;
//    private String imageUrl;


 }
