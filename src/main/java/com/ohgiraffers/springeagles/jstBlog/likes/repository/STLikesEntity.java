package com.ohgiraffers.springeagles.jstBlog.likes.repository;

import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class STLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likesId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private STPostsEntity post;

    public STLikesEntity() {
    }

    public STLikesEntity(int likesId, UserEntity user, STPostsEntity post) {
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

    public STPostsEntity getPost() {
        return post;
    }

    public void setPost(STPostsEntity post) {
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
