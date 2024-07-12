package com.ohgiraffers.springeagles.khsBlog.comment.service;

public class PostNotFound extends RuntimeException {

    public PostNotFound(String message) {
        super(message);
    }
}
