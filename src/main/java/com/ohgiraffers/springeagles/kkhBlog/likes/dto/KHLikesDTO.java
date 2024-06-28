package com.ohgiraffers.springeagles.kkhBlog.likes.dto;

public class KHLikesDTO {
    private int likesId;

    public KHLikesDTO() {
    }

    public KHLikesDTO(int likesId) {
        this.likesId = likesId;
    }

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }

}
