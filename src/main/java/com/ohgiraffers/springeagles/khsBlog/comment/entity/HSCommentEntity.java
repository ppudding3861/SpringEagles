package com.ohgiraffers.springeagles.khsBlog.comment.entity;


import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class HSCommentEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String contents;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "FK_user_comment"))
    private HSPostsEntity post;


    public void mappingPost(HSPostsEntity post) {
        this.post = post;

        post.mappingComment(this);

    }
}
