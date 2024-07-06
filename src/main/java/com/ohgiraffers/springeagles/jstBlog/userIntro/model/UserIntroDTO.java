package com.ohgiraffers.springeagles.jstBlog.userIntro.model;

import com.ohgiraffers.springeagles.jstBlog.userIntro.entity.UserIntroEntity;
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
