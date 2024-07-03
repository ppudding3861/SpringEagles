package com.ohgiraffers.springeagles.lshBlog.posts.model.dto;

import com.ohgiraffers.springeagles.lshBlog.comment.model.dto.SHCommentDTO;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SHPostsDTO {

    private Integer id;
    private String title;
    private String contents;
    private String imageUrl;
    private int likesCount;
    private List<SHCommentDTO> comments;
    private LocalDateTime createdAt;

    public SHPostsEntity toEntity() {
        SHPostsEntity build = SHPostsEntity.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .imageUrl(imageUrl)
                .likesCount(likesCount)
                .build();
        return build;
    }

    @Builder
    public SHPostsDTO(Integer id, String title, String contents, String imageUrl, int likesCount, List<SHCommentDTO> comments, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.imageUrl = imageUrl;
        this.likesCount = likesCount;
        this.comments = comments;
        this.createdAt = createdAt;
    }
}
