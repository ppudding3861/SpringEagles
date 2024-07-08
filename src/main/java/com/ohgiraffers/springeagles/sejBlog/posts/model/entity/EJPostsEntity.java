package com.ohgiraffers.springeagles.sejBlog.posts.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ej_posts")
public class EJPostsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ej_title", nullable = false)
    private String title;

    @Column(name = "ej_contents", nullable = false, length = 5000)
    private String contents;

/*
    @Column(name = "ej_image_url")
    private String imageUrl;
*/


    public EJPostsEntity() {
    }

    public EJPostsEntity(Integer id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
