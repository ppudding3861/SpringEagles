package com.ohgiraffers.springeagles.sejBlog.likes.model.dto;

public class EJLikesDTO {

    Integer likes;

    public EJLikesDTO() {
    }

    public EJLikesDTO(Integer likes) {
        this.likes = likes;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "EJLikesDTO{" +
                "likes=" + likes +
                '}';
    }
}
