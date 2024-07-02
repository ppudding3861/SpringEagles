package com.ohgiraffers.springeagles.sejBlog.likes.model.dto;

public class EJLikesDTO {
    private int likesId;

    public EJLikesDTO() {
    }

    public EJLikesDTO(int likesId) {
        this.likesId = likesId;
    }

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }
}
