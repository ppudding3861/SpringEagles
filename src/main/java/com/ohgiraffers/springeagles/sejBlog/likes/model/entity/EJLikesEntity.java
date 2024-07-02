package com.ohgiraffers.springeagles.sejBlog.likes.model.entity;

import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "ej_likes")
public class EJLikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    @ManyToOne
    @JoinColumn(name = "ej_user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "ej_id", nullable = false)
    private EJPostsEntity post;

    public EJLikesEntity() {
    }

    public EJLikesEntity(int likeId, UserEntity user, EJPostsEntity post) {
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

    public EJPostsEntity getPost() {
        return post;
    }

    public void setPost(EJPostsEntity post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "EJLikesEntity{" +
                "likeId=" + likeId +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
