package com.ohgiraffers.springeagles.jstBlog.comment.repository;

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
    @Column(name = "comment_id", nullable = false)
    private Integer commentId;

    @Column(name = "commentContent", nullable = false)
    private String commentContent;

    @Column(name = "createdDate", nullable = false)
    private LocalDate createdDate;

    @Column(name = "modifiedDate")
    private LocalDate modifiedDate;

    @Column(name = "commentAuthor", nullable = false)
    private String commentAuthor;

    @Column(name = "post_id", nullable = false)
    private Integer postId;

}
