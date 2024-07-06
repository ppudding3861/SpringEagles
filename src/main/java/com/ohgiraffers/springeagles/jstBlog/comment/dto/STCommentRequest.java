package com.ohgiraffers.springeagles.jstBlog.comment.dto;

public class STCommentRequest {

    private Integer commentId;
    private String commentContent;
    private Integer postId;
    private String userName;

    public STCommentRequest() {
    }

    public STCommentRequest(Integer commentId, String commentContent, Integer postId, String userName) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.postId = postId;
        this.userName = userName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "STCommentRequest{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", postId=" + postId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
