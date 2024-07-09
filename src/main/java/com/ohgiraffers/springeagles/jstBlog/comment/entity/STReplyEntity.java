package com.ohgiraffers.springeagles.jstBlog.comment.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "st_reply")
public class STReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer replyId;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private STCommentEntity comment;

    @ManyToOne
    @JoinColumn(name = "parent_reply_id")
    private STReplyEntity parentReply;

    @OneToMany(mappedBy = "parentReply", cascade = CascadeType.ALL)
    private List<STReplyEntity> childReplies;

    @Column(name = "reply_content")
    private String content;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "reply_depth")
    private Integer depth;

    @Column(name = "reply_username")
    private String username;

    public STReplyEntity() {
    }

    public STReplyEntity(Integer replyId, STCommentEntity comment, STReplyEntity parentReply, List<STReplyEntity> childReplies, String content, LocalDate createdDate, Integer depth, String username) {
        this.replyId = replyId;
        this.comment = comment;
        this.parentReply = parentReply;
        this.childReplies = childReplies;
        this.content = content;
        this.createdDate = createdDate;
        this.depth = depth;
        this.username = username;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public STCommentEntity getComment() {
        return comment;
    }

    public void setComment(STCommentEntity comment) {
        this.comment = comment;
    }

    public STReplyEntity getParentReply() {
        return parentReply;
    }

    public void setParentReply(STReplyEntity parentReply) {
        this.parentReply = parentReply;
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

    public List<STReplyEntity> getChildReplies() {
        return childReplies;
    }

    public void setChildReplies(List<STReplyEntity> childReplies) {
        this.childReplies = childReplies;
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
        return "STReplyEntity{" +
                "replyId=" + replyId +
                ", comment=" + comment +
                ", parentReply=" + parentReply +
                ", childReplies=" + childReplies +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", depth=" + depth +
                ", username='" + username + '\'' +
                '}';
    }
}
