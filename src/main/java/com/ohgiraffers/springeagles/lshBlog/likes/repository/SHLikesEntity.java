package com.ohgiraffers.springeagles.lshBlog.likes.repository;

import com.ohgiraffers.springeagles.lshBlog.posts.repository.SHPostsEntity;
import com.ohgiraffers.springeagles.lshBlog.user.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class SHLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likesId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SHPostsEntity post;

    public SHLikesEntity() {
    }

    public SHLikesEntity(int likesId, UserEntity user, SHPostsEntity post) {
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

    public SHPostsEntity getPost() {
        return post;
    }

    public void setPost(SHPostsEntity post) {
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
