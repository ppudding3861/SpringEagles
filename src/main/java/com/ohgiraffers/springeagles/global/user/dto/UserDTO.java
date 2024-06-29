package com.ohgiraffers.springeagles.global.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Integer userID;
    private String userName;
    private String userPassword;
    private String userEmail;
}
