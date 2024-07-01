package com.ohgiraffers.springeagles.jstBlog.comment.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class STCommentDTO {

    private Integer commentId;
    private String commentContent;
    private LocalDate commentDate;
    private LocalDate commentModifyTime;
    private String commentAuthor;
    private Integer postId;
}
