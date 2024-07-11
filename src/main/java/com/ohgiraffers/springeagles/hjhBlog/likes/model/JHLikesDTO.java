package com.ohgiraffers.springeagles.hjhBlog.likes.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JHLikesDTO {
    private Integer likesId;
    private Integer userId;
    private Integer postId;
}
