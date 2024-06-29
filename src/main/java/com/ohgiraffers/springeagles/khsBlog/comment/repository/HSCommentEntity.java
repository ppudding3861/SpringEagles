package com.ohgiraffers.springeagles.khsBlog.comment.repository;

import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "hs-comments")
public class HSCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentID;

    @Column(name = "commentContent", nullable = false)
    private String commentContent;

    @Column(name = "createdDate", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "modifiedDate")
    private LocalDateTime modifiedDate;

    @Column(name = "commentAuthor", nullable = false)
    private String commentAuthor;

    // 다대일 관계: 여러 댓글은 하나의 포스트에 속함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private HSPostsEntity hsPostsEntity;

    // 기본 생성자
    public HSCommentEntity() {}

    // 매개변수를 받는 생성자
    public HSCommentEntity(Long commentID, String commentContent, LocalDateTime createdDate, LocalDateTime modifiedDate, String commentAuthor) {
        this.commentID = commentID;
        this.commentContent = commentContent;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.commentAuthor = commentAuthor;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public HSPostsEntity getPostsEntity() {
        return hsPostsEntity;
    }

    public void setPostsEntity(HSPostsEntity hsPostsEntity) {
        this.hsPostsEntity = hsPostsEntity;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "commentID=" + commentID +
                ", commentContent='" + commentContent + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", commentAuthor='" + commentAuthor + '\'' +
                ", hsPostsEntity=" + hsPostsEntity +
                '}';
    }
}
