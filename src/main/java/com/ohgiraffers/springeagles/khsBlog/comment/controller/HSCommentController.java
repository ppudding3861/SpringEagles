package com.ohgiraffers.springeagles.khsBlog.comment.controller;

import com.ohgiraffers.springeagles.khsBlog.comment.model.HSCommentDTO;
import com.ohgiraffers.springeagles.khsBlog.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/khs/blog")
public class HSCommentController {

    private final CommentService commentService;

    @PostMapping("/postreader/{id}/comment")
    public ResponseEntity<HSCommentDTO> createComment(@PathVariable(name = "id") Long postId,
                                                      @Valid @RequestBody HSCommentDTO commentDTO) {
        HSCommentDTO comment = commentService.createComment(postId, commentDTO);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
}
