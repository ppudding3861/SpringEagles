package com.ohgiraffers.springeagles.hjhBlog.posts.controller;


import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.service.JHPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hjh/blog")
public class JHPostsController {

    private final JHPostsService jhPostsService;

    @Autowired
    public JHPostsController(JHPostsService jhPostsService) {
        this.jhPostsService = jhPostsService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", jhPostsService.getAllPosts());
        return "hjh_blog/blogPost6";
    }

    @GetMapping("/post/{postId}")
    public String getPostById(@PathVariable("postId") Integer postId, Model model) {
        JHPostsEntity post = jhPostsService.getPostById(postId).orElse(null); // id에 해당하는 게시물을 조회
        if (post == null) {
            return "redirect:/hjh/blog/posts"; // 게시물이 없으면 목록 페이지로 리다이렉트
        }
        return "hjh_blog/blogPost6";
    }
}
