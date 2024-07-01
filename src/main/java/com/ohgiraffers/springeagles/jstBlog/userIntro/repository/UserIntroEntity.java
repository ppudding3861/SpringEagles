package com.ohgiraffers.springeagles.jstBlog.userIntro.repository;

import com.ohgiraffers.springeagles.jstBlog.userIntro.dto.UserIntroDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "st_intro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserIntroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intro_id", nullable = false)
    private Integer introId;

    @Column(name = "intro_content", nullable = false, columnDefinition = "TINYTEXT")
    private String introContent;

    // dto -> entity
    public UserIntroEntity(UserIntroDTO dto) {
        this.introId = dto.getIntroId();
        this.introContent = dto.getIntroContent();
    }
}
