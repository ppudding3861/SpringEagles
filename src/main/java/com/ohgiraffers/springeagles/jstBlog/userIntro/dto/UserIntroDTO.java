package com.ohgiraffers.springeagles.jstBlog.userIntro.dto;

import com.ohgiraffers.springeagles.jstBlog.userIntro.repository.UserIntroEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserIntroDTO {

    private Integer IntroId;
    private String IntroContent;

    // entity -> dto
    public UserIntroDTO(UserIntroEntity entity) {
        this.IntroId = entity.getIntroId();
        this.IntroContent = entity.getIntroContent();
    }
}
