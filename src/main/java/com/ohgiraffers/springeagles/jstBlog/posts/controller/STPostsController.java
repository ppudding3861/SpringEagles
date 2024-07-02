package com.ohgiraffers.springeagles.jstBlog.posts.controller;

//import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.service.STCommentService;
import com.ohgiraffers.springeagles.jstBlog.posts.dto.STPostsDTO;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import com.ohgiraffers.springeagles.jstBlog.userIntro.service.UserIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/stj/blog")
public class STPostsController {

    private final STPostsService stPostsService;
    private final UserIntroService userIntroService;
    private final STCommentService stCommentService;

    @Autowired
    public STPostsController(STPostsService stPostsService, UserIntroService userIntroService, STCommentService stCommentService) {
        this.stPostsService = stPostsService;
        this.userIntroService = userIntroService;
        this.stCommentService = stCommentService;
    }

    @GetMapping("/posts")
    public String getAllPosts(@RequestParam(value = "postId", required = false) Integer postId, Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Integer> tagCounts = stPostsService.calculateTagCounts();
        String introContent = userIntroService.getIntroContent();
        if (introContent == null) {
            introContent = "자기소개를 입력해주세요.";
        }
        List<STPostsEntity> posts = stPostsService.getAllPosts();
        Map<Integer, Integer> commentCounts = new HashMap<>();

        for (STPostsEntity post : posts) {
            int commentCount = stPostsService.getCommentCountByPostId(post.getPostId());
            commentCounts.put(post.getPostId(), commentCount);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("commentCounts", commentCounts);
        model.addAttribute("tagCounts", tagCounts);
//        model.addAttribute("username", authentication.getName());
        model.addAttribute("introContent", introContent);
        model.addAttribute("currentPage", "mainPage");
        return "jst_blog/blogPost";
    }

    @GetMapping("/post/{postId}")
    public String getPostById(@PathVariable("postId") Integer postId, Model model) {
        STPostsEntity post = stPostsService.getPostById(postId).orElse(null); // id에 해당하는 게시물을 조회
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
        if (post == null) {
            return "redirect:/stj/blog/posts"; // 게시물이 없으면 목록 페이지로 리다이렉트
        }

        // 댓글 리스트를 조회하여 모델에 추가
        List<STCommentEntity> comments = stCommentService.getCommentsByPost(postId);

        model.addAttribute("post", post); // 특정 게시물을 모델에 추가
        model.addAttribute("selectedId", postId); // 선택된 게시물 ID를 모델에 추가
        model.addAttribute("comments", comments); // 댓글 리스트를 모델에 추가
//        model.addAttribute("username", authentication.getName());
//        model.addAttribute("username", username);
        model.addAttribute("currentPage", "readPage");
        return "jst_blog/blogPost"; // 게시물 상세 페이지 뷰 이름
    }

    // 게시물 작성 페이지
    @GetMapping("/edit")
    public String showCreateForm(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("postDTO", new STPostsDTO()); // 빈 게시물 DTO를 모델에 추가
//        model.addAttribute("username", authentication.getName());
        model.addAttribute("currentPage", "editPage");
        return "jst_blog/blogPost"; // 게시물 작성 폼을 보여줄 뷰 이름
    }

    // 게시물 작성 처리
    @PostMapping("/edit")
    public ResponseEntity<String> responseEdit(@RequestBody STPostsDTO stPostsDTO) {
        try {
            stPostsService.createPost(stPostsDTO); // 게시물 생성 서비스 호출
            return ResponseEntity.ok("게시물 작성이 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 작성 중 오류가 발생했습니다.");
        }
    }

    // 게시물 수정 페이지 GET
    @GetMapping("/update/{postId}")
    public String showUpdateForm(@PathVariable("postId") Integer postId, Model model) {
        STPostsEntity postEntity = stPostsService.getPostById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다. ID: " + postId));
        STPostsDTO postDTO = new STPostsDTO(postEntity); // 엔티티에서 DTO로 매핑
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("postDTO", postDTO); // 게시물 DTO를 모델에 추가
//        model.addAttribute("username", authentication.getName());
        model.addAttribute("currentPage", "updatePage");
        return "jst_blog/blogPost"; // 게시물 수정 폼을 보여줄 뷰 이름
    }

    // 게시물 수정 처리 POST
    @PostMapping("/update/{postId}")
    public RedirectView updatePost(@PathVariable("postId") Integer postId, @RequestBody STPostsDTO stPostsDTO) {
        try {
            stPostsDTO.setPostId(postId); // DTO에 PathVariable로 받은 postId 설정
            stPostsService.updatePost(stPostsDTO); // 게시물 수정 서비스 호출
            // 수정 완료 후 /posts/{postId}로 리다이렉트
            return new RedirectView("/stj/blog/posts", true);
        } catch (Exception e) {
            // 수정 실패 시 오류 페이지로 리다이렉트
            return new RedirectView("/error", true);
        }
    }


    // 게시물 삭제 처리
    @PostMapping("/delete/{postId}")
    public RedirectView deletePost(@PathVariable("postId") Integer postId) {
        try {
            stPostsService.deletePost(postId); // 게시물 삭제 서비스 호출
            // 삭제 완료 후 /posts로 리다이렉트
            return new RedirectView("/stj/blog/posts", true);
        } catch (Exception e) {
            // 삭제 실패 시 오류 페이지로 리다이렉트
            return new RedirectView("/error", true);
        }
    }
}
