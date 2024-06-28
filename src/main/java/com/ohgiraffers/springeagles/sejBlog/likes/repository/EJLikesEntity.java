package com.ohgiraffers.springeagles.sejBlog.likes.repository;

import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.user.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class EJLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likesId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private EJPostsEntity post;

    public EJLikesEntity() {
    }

    public EJLikesEntity(int likesId, UserEntity user, EJPostsEntity post) {
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

    public EJPostsEntity getPost() {
        return post;
    }

    public void setPost(EJPostsEntity post) {
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
