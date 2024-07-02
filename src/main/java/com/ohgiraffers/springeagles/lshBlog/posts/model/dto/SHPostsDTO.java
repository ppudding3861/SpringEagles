package com.ohgiraffers.springeagles.lshBlog.posts.model.dto;

import com.ohgiraffers.springeagles.lshBlog.comment.model.dto.SHCommentDTO;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;

import java.time.LocalDateTime;
import java.util.List;

public class SHPostsDTO {

    private int id;
    private String title;
    private String contents;
    private String imageUrl;
    private String tagArrayAsString;
    private int likesCount;
    private List<SHCommentDTO> comments;
    private int commentsCount;
    private LocalDateTime createdAt;

    public SHPostsDTO() {
    }

    public SHPostsDTO(int id, String title, String contents, String imageUrl, String tagArrayAsString, int likesCount, List<SHCommentDTO> comments, int commentsCount, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.imageUrl = imageUrl;
        this.tagArrayAsString = tagArrayAsString;
        this.likesCount = likesCount;
        this.comments = comments;
        this.commentsCount = commentsCount;
        this.createdAt = createdAt;
    }
    public SHPostsEntity toEntity(){
        return new SHPostsEntity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTagArrayAsString() {
        return tagArrayAsString;
    }

    public void setTagArrayAsString(String tagArrayAsString) {
        this.tagArrayAsString = tagArrayAsString;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<SHCommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<SHCommentDTO> comments) {
        this.comments = comments;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SHPostsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tagArrayAsString='" + tagArrayAsString + '\'' +
                ", likesCount=" + likesCount +
                ", comments=" + comments +
                ", commentsCount=" + commentsCount +
                ", createdAt=" + createdAt +
                '}';
    }
}
