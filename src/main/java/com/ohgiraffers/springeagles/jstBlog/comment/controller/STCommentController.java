package com.ohgiraffers.springeagles.jstBlog.comment.controller;

import com.ohgiraffers.springeagles.global.error.ResourceNotFoundException;
import com.ohgiraffers.springeagles.jstBlog.comment.dto.STCommentDTO;
import com.ohgiraffers.springeagles.jstBlog.comment.service.STCommentService;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class STCommentController {

    private final STPostsService STPostsService;
    private final STCommentService STCommentService;

    @Autowired
    public STCommentController(STCommentService STCommentService, STPostsService STPostsService) {
        this.STPostsService = STPostsService;
        this.STCommentService = STCommentService;
    }

    // 모든 댓글 조회 API
    @GetMapping
    public List<STCommentDTO> getAllComments() {
        return STCommentService.getAllComments();
    }

    // ID로 댓글 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<STCommentDTO> getCommentById(@PathVariable Long id) {
        STCommentDTO comment = STCommentService.getCommentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));
        return ResponseEntity.ok(comment);
    }

    // 댓글 생성 API
    @PostMapping
    public STCommentDTO createComment(@RequestBody STCommentDTO comment) {
        return STCommentService.createComment(comment);
    }

    // 댓글 수정 API
    @PutMapping("/{id}")
    public ResponseEntity<STCommentDTO> updateComment(@PathVariable Long id, @RequestBody STCommentDTO commentDetails) {
        STCommentDTO updatedComment = STCommentService.updateComment(id, commentDetails);
        return ResponseEntity.ok(updatedComment);
    }

    // 특정 포스트에 대한 댓글 목록 조회 메서드
    @GetMapping("/{postId}/comments")
    public String viewCommentsByPostId(@PathVariable Long postId, Model model) {
        // postId를 기반으로 해당 포스트에 대한 모든 댓글을 가져옴
        List<STCommentDTO> comments = STCommentService.getCommentsByPostId(postId);

        // 모델에 댓글 목록과 빈 댓글 객체 추가
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new STCommentDTO()); // 빈 댓글 객체를 모델에 추가

        // 현재 포스트 ID도 모델에 추가 (템플릿에서 사용될 수 있음)
        model.addAttribute("postId", postId);

        // 뷰 페이지의 이름을 반환
        return "post-comments";
    }
}
