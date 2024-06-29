package com.ohgiraffers.springeagles.khsBlog.likes.repository;

import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "hs-likes")
public class HSLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likesId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private HSPostsEntity post;

    public HSLikesEntity() {
    }

    public HSLikesEntity(int likesId, UserEntity user, HSPostsEntity post) {
        this.likesId = likesId;
        this.user = user;
        this.post = post;
    }

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public HSPostsEntity getPost() {
        return post;
    }

    public void setPost(HSPostsEntity post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "LikesEntity{" +
                "likesId=" + likesId +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
