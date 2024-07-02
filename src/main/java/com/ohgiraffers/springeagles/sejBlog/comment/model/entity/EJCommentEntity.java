package com.ohgiraffers.springeagles.sejBlog.comment.model.entity;

import com.ohgiraffers.springeagles.sejBlog.posts.model.entity.EJPostsEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ej_comments")
public class EJCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "ej_commentContent", nullable = false)
    private String commentContent;

    @Column(name = "ej_createdDate", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "ej_commentAuthor", nullable = false)
    private String commentAuthor;

    @ManyToOne(fetch = FetchType.LAZY) // 괄호 뒤에 붙는건 느슨한 결합 뭐 그건가?
    @JoinColumn(name = "ej_post_id", nullable = false)
    private EJPostsEntity postsEntity;

    public EJCommentEntity() {
    }

    public EJCommentEntity(int commentId, String commentContent, LocalDateTime createdDate, String commentAuthor, EJPostsEntity ejPostsEntity) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.createdDate = createdDate;
        this.commentAuthor = commentAuthor;
//        this.EJPostsEntity = EJPostsEntity; 왜 오류?
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public EJPostsEntity getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(EJPostsEntity postsEntity) {
        this.postsEntity = postsEntity;
    }

    @Override
    public String toString() {
        return "EJCommentEntity{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", createdDate=" + createdDate +
                ", commentAuthor='" + commentAuthor + '\'' +
                ", postsEntity=" + postsEntity +
                '}';
    }
}
