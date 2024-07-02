package com.ohgiraffers.springeagles.sejBlog.comment.model.dto;

import java.time.LocalDateTime;

public class EJCommentDTO {
    private int commentId;
    private String commentContent;
    private LocalDateTime commentDate;
    private String commentAuthor;

    public EJCommentDTO() {
    }

    public EJCommentDTO(int commentId, String commentContent, LocalDateTime commentDate, String commentAuthor) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentAuthor = commentAuthor;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    @Override
    public String toString() {
        return "SHCommentDTO{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", commentDate=" + commentDate +
                ", commentAuthor='" + commentAuthor + '\'' +
                '}';
    }
}
