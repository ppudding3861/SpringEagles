package com.ohgiraffers.springeagles.sejBlog.posts.model.dto;

import com.ohgiraffers.springeagles.sejBlog.comment.model.dto.EJCommentDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EJPostsDTO {

    private int id;
    private String title;
    private String contents;
    private String imageUrl;
    private String tagArrayAsString;
    private int likesCount;
    private List<EJCommentDTO> comments;
    private int commentsCount;
    private LocalDateTime createdAt;

 }
