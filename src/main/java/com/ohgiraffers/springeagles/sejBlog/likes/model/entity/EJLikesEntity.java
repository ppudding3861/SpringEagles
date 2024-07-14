package com.ohgiraffers.springeagles.sejBlog.likes.model.entity;


import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "ej_likes")
public class EJLikesEntity {
    @Id
    @Column(name = "likes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likesId;

    // 일대다 관계 - 하나의 블로그 포스트가 여러개의 좋아요를 가질 수 있도록 설정한다
    // id 는 블로그 포스트의 postId의 컬럼 이름이다.
    @ManyToOne
    @JoinColumn(name = "id")
    private EJPostsEntity posts;

    @Column(name = "like_count")
    private Integer likes;

    public EJLikesEntity() {
    }

    public EJLikesEntity(EJPostsEntity posts, Integer likes) {
        this.posts = posts;
        this.likes = likes;
    }

    public Integer getLikesId() {
        return likesId;
    }

    public void setLikesId(Integer likesId) {
        this.likesId = likesId;
    }

    public EJPostsEntity getPosts() {
        return posts;
    }

    public void setPosts(EJPostsEntity posts) {
        this.posts = posts;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "EJLikesEntity{" +
                "likesId=" + likesId +
                ", posts=" + posts +
                ", likes=" + likes +
                '}';
    }
}
