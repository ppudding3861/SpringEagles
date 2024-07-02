package com.ohgiraffers.springeagles.lshBlog.likes.model.entity;

import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "sh_likes")
public class SHLikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    @ManyToOne
    @JoinColumn(name = "sh_user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "sh_id", nullable = false)
    private SHPostsEntity post;

    public SHLikesEntity() {
    }

    public SHLikesEntity(int likeId, UserEntity user, SHPostsEntity post) {
        this.likeId = likeId;
        this.user = user;
        this.post = post;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
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
        return "SHLikesEntity{" +
                "likeId=" + likeId +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
