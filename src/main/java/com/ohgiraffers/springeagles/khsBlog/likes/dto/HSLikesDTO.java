package com.ohgiraffers.springeagles.khsBlog.likes.dto;

public class HSLikesDTO {

    private Integer likes;

    public HSLikesDTO() {
    }

    public HSLikesDTO(Integer likes) {
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
        return "HSLikesDTO{" +
                "likes=" + likes +
                '}';
    }
}
