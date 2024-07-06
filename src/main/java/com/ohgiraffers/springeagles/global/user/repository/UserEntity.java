package com.ohgiraffers.springeagles.global.user.repository;

import com.ohgiraffers.springeagles.global.user.dto.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "global_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
