package com.ohgiraffers.springeagles.sejBlog.posts.model.dto;

public class EJPostsDTO {

    private Integer id;
    private String title;
    private String contents;
//    private String imageUrl;


    public EJPostsDTO() {
    }

    public EJPostsDTO(Integer id, String title, String contents) {
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
        return "EJPostsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
