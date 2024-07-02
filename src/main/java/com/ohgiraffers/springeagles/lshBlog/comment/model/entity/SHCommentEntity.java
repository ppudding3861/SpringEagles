package com.ohgiraffers.springeagles.lshBlog.comment.model.entity;

import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sh_comments")
public class SHCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "sh_commentContent", nullable = false)
    private String commentContent;

    @Column(name = "sh_createdDate", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "sh_commentAuthor", nullable = false)
    private String commentAuthor;

    @ManyToOne(fetch = FetchType.LAZY) // 괄호 뒤에 붙는건 느슨한 결합 뭐 그건가?
    @JoinColumn(name = "sh_post_id", nullable = false)
    private SHPostsEntity postsEntity;

    public SHCommentEntity() {
    }

    public SHCommentEntity(int commentId, String commentContent, LocalDateTime createdDate, String commentAuthor, SHPostsEntity SHPostsEntity) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.createdDate = createdDate;
        this.commentAuthor = commentAuthor;
//        this.SHPostsEntity = SHPostsEntity; 왜 오류?
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

    public SHPostsEntity getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(SHPostsEntity postsEntity) {
        this.postsEntity = postsEntity;
    }

    @Override
    public String toString() {
        return "SHCommentEntity{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", createdDate=" + createdDate +
                ", commentAuthor='" + commentAuthor + '\'' +
                ", postsEntity=" + postsEntity +
                '}';
    }
}
