package com.ohgiraffers.springeagles.hjhBlog.likes.repository;

import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.user.model.UserJHEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class JHLikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likesId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserJHEntity user;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private JHPostsEntity post;

    public JHLikesEntity() {
    }

    public JHLikesEntity(int likesId, UserJHEntity user, JHPostsEntity post) {
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

    public UserJHEntity getUser() {
        return user;
    }

    public void setUser(UserJHEntity user) {
        this.user = user;
    }

    public JHPostsEntity getPost() {
        return post;
    }

    public void setPost(JHPostsEntity post) {
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
