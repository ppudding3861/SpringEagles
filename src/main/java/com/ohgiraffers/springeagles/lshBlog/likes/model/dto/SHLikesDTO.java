package com.ohgiraffers.springeagles.lshBlog.likes.model.dto;

public class SHLikesDTO {
    private int likesId;

    public SHLikesDTO() {
    }

    public SHLikesDTO(int likesId) {
        this.likesId = likesId;
    }

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }
}
