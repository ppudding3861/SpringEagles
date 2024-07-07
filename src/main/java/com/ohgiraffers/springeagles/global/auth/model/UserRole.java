package com.ohgiraffers.springeagles.global.auth.model;

public enum UserRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    JST("ROLE_JST"),
    SEJ("ROLE_SEJ"),
    KHS("ROLE_KHS"),
    KKH("ROLE_KKH"),
    LSH("ROLE_LSH"),
    HJH("ROLE_HJH");

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
