package com.ohgiraffers.springeagles.sejBlog.posts.model.dto;

public class EJPostsDTO {

    private Integer postId;
    private String title;
    private String contents;
//    private String imageUrl;


    public EJPostsDTO() {
    }

    public EJPostsDTO(Integer postId, String title, String contents) {
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
        return "EJPostsDTO{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
