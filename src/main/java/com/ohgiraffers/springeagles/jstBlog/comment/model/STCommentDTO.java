package com.ohgiraffers.springeagles.jstBlog.comment.model;

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
    private Integer postId;
    private String userName;
}
