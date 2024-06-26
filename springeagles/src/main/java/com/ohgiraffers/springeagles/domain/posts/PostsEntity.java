package com.ohgiraffers.springeagles.domain.posts;

import com.ohgiraffers.springeagles.domain.comment.CommentDTO;
import com.ohgiraffers.springeagles.domain.comment.CommentEntity;
import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "posts")
public class PostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url")
    @Size(max = 255)
    private String imageUrl;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "tag_array")
    private String tagArrayAsString; // 문자열로 변환된 tagArray


    @Column(name = "likes_count")
    private int likesCount;

    // 일대다 관계: 하나의 포스트에 여러 댓글이 있을 수 있음
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postsEntity")
    private List<CommentEntity> comments = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public PostsEntity() {
    }

    public PostsEntity(Long id, String title, String description, String imageUrl, String content,
                       LocalDateTime createdAt, String tagArrayAsString, int likesCount,
                       List<CommentEntity> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.createdAt = createdAt;
        this.tagArrayAsString = tagArrayAsString;
        this.likesCount = likesCount;
        this.comments = comments;
    }

    // Constructor to convert DTO to Entity
    public PostsEntity(PostsDTO dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.imageUrl = dto.getImageUrl();
        this.content = dto.getContent();
        this.createdAt = dto.getCreatedAt();
        this.tagArrayAsString = Arrays.toString(dto.getTagArray());
        this.likesCount = dto.getLikesCount();

        if (dto.getComments() != null) {
            this.comments = dto.getComments().stream()
                    .map(CommentDTO::toEntity)
                    .collect(Collectors.toList());
        } else {
            this.comments = new ArrayList<>();
        }
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String[] getTagArray() {
        return tagArrayAsString != null ? tagArrayAsString.split(",") : new String[0];
    }

    public void setTagArray(String[] tagArray) {
        this.tagArrayAsString = tagArray != null ? String.join(",", tagArray) : "";
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    @Transient // 데이터베이스에 매핑하지 않음
    public int getCommentsCount() {
        return this.comments.size(); // comments 리스트의 사이즈를 반환
    }

    @Override
    public String toString() {
        return "PostsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", tagArrayAsString='" + tagArrayAsString + '\'' +
                ", likesCount=" + likesCount +
                ", comments=" + comments +
                '}';
    }
}
