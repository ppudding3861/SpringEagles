package com.ohgiraffers.springeagles.global.auth.model;

public enum UserRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    OWNER("ROLE_OWNER");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
