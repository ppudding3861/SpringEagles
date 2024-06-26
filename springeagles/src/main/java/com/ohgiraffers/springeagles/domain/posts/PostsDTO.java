package com.ohgiraffers.springeagles.domain.posts;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PostsDTO {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private LocalDateTime createdAt;
    private String tagArray;
    private int likesCount;
    private int commentsCount; // 이 필드는 계산을 통해 설정될 예정

    public PostsDTO() {
    }

    public PostsDTO(Long id, String title, String description, String imageUrl, String content,
                    LocalDateTime createdAt, String tagArray, int likesCount, int commentsCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.createdAt = createdAt;
        this.tagArray = tagArray;
        this.likesCount = likesCount;
        this.commentsCount = commentsCount;
    }

    // PostsEntity를 기반으로 PostsDTO를 생성하는 정적 메소드
    public static PostsDTO fromEntity(PostsEntity entity) {
        return new PostsDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getImageUrl(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getTagArray(),
                entity.getLikesCount(),
                entity.getComments().size() // 댓글 수는 comments 리스트의 사이즈로 설정
        );
    }

    // PostsDTO를 기반으로 PostsEntity를 생성하는 메소드
    public PostsEntity toEntity() {
        return new PostsEntity(
                this.id,
                this.title,
                this.description,
                this.imageUrl,
                this.content,
                this.createdAt,
                this.tagArray,
                this.likesCount,
                null // comments는 null로 설정
        );
    }

    // Getter 및 Setter는 생략 (필요시 추가)

    @Override
    public String toString() {
        return "PostsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", tagArray='" + tagArray + '\'' +
                ", likesCount=" + likesCount +
                ", commentsCount=" + commentsCount +
                '}';
    }
}
