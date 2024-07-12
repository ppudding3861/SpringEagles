package com.ohgiraffers.springeagles.khsBlog.comment.model;

import com.ohgiraffers.springeagles.khsBlog.comment.entity.HSCommentEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@NoArgsConstructor // 기본 생성자를 생성
@ToString // toString 메소드를 생성
public class HSCommentDTO {
    private Long id;

    @NotBlank
    private String contents;

    public static HSCommentDTO convertToCommentDto(HSCommentEntity comment) {
        return HSCommentDTO.builder()
                .contents(comment.getContents())
                .build();
    }

    public static List<HSCommentDTO> convertToCommentDtoList(List<HSCommentEntity> commentList) {
        Stream<HSCommentEntity> stream = commentList.stream();

        return stream.map(HSCommentDTO::convertToCommentDto).collect(Collectors.toList());

    }
}