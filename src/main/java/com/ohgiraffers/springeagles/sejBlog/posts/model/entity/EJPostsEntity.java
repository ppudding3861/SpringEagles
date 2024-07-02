package com.ohgiraffers.springeagles.sejBlog.posts.model.entity;

import com.ohgiraffers.springeagles.sejBlog.comment.model.entity.EJCommentEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ej_posts")
public class EJPostsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ej_title", unique = true, nullable = false)
    private String title;

    @Column(name = "ej_contents", nullable = false, length = 5000)
    private String contents;

    @Column(name = "ej_image_url")
    private String imageUrl;

    @Column(name = "ej_tag_array")
    private String tagArrayAsString;

    @Column(name = "ej_likes_count")
    private int likesCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postsEntity")
    private List<EJCommentEntity> comments;

    //created_at : 생성된 시간을 저장한다
    //updatable = false : 필드값이 업데이트 될 수 없음, 엔터티가 데이터베이스에 처음 저장될 때만 이 필드에 값이 설정되고
    // 이 후 업데이트시에는 변경되지 않음. 처음 작성날짜가 기록된 채로 변경되지 않게 설정할 수 있음.
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // PrePersist 어노테이션은 JPA 엔터티가 처음 영속성 컨텍스트에 저장되기 전에 실행될 메서드
    // 생성시간을 설정하거나 기본값을 초기화하는데 사용됨.
    // LocalDateTime.now 가 현재 시스템 시간을 가져오는 함수다. 이 함수를 사용해서 created_at 필드에 넣어줌.

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public EJPostsEntity() {
    }

    public EJPostsEntity(int id, String title, String contents, String imageUrl, String tagArrayAsString, int likesCount, List<EJCommentEntity> comments, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.imageUrl = imageUrl;
        this.tagArrayAsString = tagArrayAsString;
        this.likesCount = likesCount;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTagArrayAsString() {
        return tagArrayAsString;
    }

    public void setTagArrayAsString(String tagArrayAsString) {
        this.tagArrayAsString = tagArrayAsString;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<EJCommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<EJCommentEntity> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SHPostsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tagArrayAsString='" + tagArrayAsString + '\'' +
                ", likesCount=" + likesCount +
                ", comments=" + comments +
                ", createdAt=" + createdAt +
                '}';
    }
}
