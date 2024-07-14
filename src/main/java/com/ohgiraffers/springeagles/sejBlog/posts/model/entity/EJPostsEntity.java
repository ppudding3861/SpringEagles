package com.ohgiraffers.springeagles.sejBlog.posts.model.entity;

import com.ohgiraffers.springeagles.sejBlog.likes.model.entity.EJLikesEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ej_posts")
public class EJPostsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name = "ej_title", nullable = false)
    private String title;

    @Column(name = "ej_contents", nullable = false, length = 5000)
    private String contents;

    // mapped by : ejPostsEntity
    // LikesEntity 클래스의 ejPostsEntity 필드가 이 관계의 주인임을 나타낸다..
    // 즉, EJLikesEntity의 ejPostsEntity 필드가 EJPostsEntity와의 관계를 매핑.
    //
    // cascade = CascadeType.ALL: EJPostsEntity
    // 객체에 대해 수행된 모든 작업(저장, 업데이트, 삭제 등)이 관련된 EJLikesEntity 객체에도 적용.
    // Post 가 삭제되면, 좋아요도 없어져야 함.
    //
    // orphanRemoval = true: likes 컬렉션에서 EJLikesEntity 객체가 제거되면,
    // 해당 EJLikesEntity 객체가 데이터베이스에서도 삭제
    // 컬렉션 : Map, Set, List

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EJLikesEntity> likes = new HashSet<>();

/*
    @Column(name = "ej_image_url")
    private String imageUrl;
*/

    public EJPostsEntity() {
    }

    public EJPostsEntity(Integer postId, String title, String contents) {
        this.postId = postId;
        this.title = title;
        this.contents = contents;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "EJPostsEntity{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
