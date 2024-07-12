package com.ohgiraffers.springeagles.khsBlog.likes.entity;

import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "hs_likes")
public class HSLikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "postId")
    private HSPostsEntity post;

    @Column(name = "likes")
    private Integer likes;

    public HSLikesEntity() {}

    public HSLikesEntity(HSPostsEntity post, Integer likes) {
        this.post = post;
        this.likes = likes;
    }



    public Integer getId() {
        return id;
    }

    public HSPostsEntity getPost() {
        return post;
    }

    public void setPost(HSPostsEntity post) {
        this.post = post;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "HSLikesEntity{" +
                "id=" + id +
                ", post=" + post +
                ", likes=" + likes +
                '}';
    }
}
