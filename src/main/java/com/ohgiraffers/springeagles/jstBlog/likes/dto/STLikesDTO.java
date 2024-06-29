package com.ohgiraffers.springeagles.jstBlog.likes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class STLikesDTO {
    private Integer likesId;
    private Integer userId;
    private Integer postId;
}
