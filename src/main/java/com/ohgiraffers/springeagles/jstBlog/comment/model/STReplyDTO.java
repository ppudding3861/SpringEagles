package com.ohgiraffers.springeagles.jstBlog.comment.model;

import java.time.LocalDate;

public class STReplyDTO {

    private Integer replyId;
    private String content;
    private LocalDate createdDate;
    private Integer commentId;
    private Integer parentReplyId;
    private Integer depth;
    private String username;

    public STReplyDTO() {
    }

    public STReplyDTO(Integer replyId, String content, LocalDate createdDate, Integer commentId, Integer parentReplyId, Integer depth, String username) {
        this.replyId = replyId;
        this.content = content;
        this.createdDate = createdDate;
        this.commentId = commentId;
        this.parentReplyId = parentReplyId;
        this.depth = depth;
        this.username = username;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(Integer parentReplyId) {
        this.parentReplyId = parentReplyId;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "STReplyDTO{" +
                "replyId=" + replyId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", commentId=" + commentId +
                ", parentReplyId=" + parentReplyId +
                ", depth=" + depth +
                ", username='" + username + '\'' +
                '}';
    }
}
