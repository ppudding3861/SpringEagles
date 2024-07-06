package com.ohgiraffers.springeagles.jstBlog.comment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "st_comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class STCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false, columnDefinition = "INTEGER")
    private Integer commentId;

    @Column(name = "commentContent", nullable = false)
    private String commentContent;

    @Column(name = "createdDate", nullable = false)
    private LocalDate createdDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDate.now();
    }

    @Column(name = "modifiedDate")
    private LocalDate modifiedDate;

    protected void onUpdate() {
        modifiedDate = LocalDate.now();
    }

    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(name = "user_Name", nullable = false)
    private String userName;

}
