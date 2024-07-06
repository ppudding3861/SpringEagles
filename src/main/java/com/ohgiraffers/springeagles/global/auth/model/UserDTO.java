package com.ohgiraffers.springeagles.global.auth.model;

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
    private String role;
}
