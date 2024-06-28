package com.ohgiraffers.springeagles.kkhBlog.likes.repository;

import com.ohgiraffers.springeagles.kkhBlog.posts.repository.KHPostsEntity;
import com.ohgiraffers.springeagles.kkhBlog.user.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class KHLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likesId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private KHPostsEntity post;

    public KHLikesEntity() {
    }

    public KHLikesEntity(int likesId, UserEntity user, KHPostsEntity post) {
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

    public KHPostsEntity getPost() {
        return post;
    }

    public void setPost(KHPostsEntity post) {
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
