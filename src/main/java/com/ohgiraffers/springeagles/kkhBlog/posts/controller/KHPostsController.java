package com.ohgiraffers.springeagles.kkhBlog.posts.controller;

import com.ohgiraffers.springeagles.kkhBlog.posts.dto.KHPostsDTO;
import com.ohgiraffers.springeagles.kkhBlog.posts.service.KHPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class KHPostsController {

    private final KHPostsService KHPostsService;

    @Autowired
    public KHPostsController(KHPostsService KHPostsService) {
        this.KHPostsService = KHPostsService;
    }

    @PostMapping("/saveMarkdown")
    @ResponseBody
    public ResponseEntity<String> saveMarkdown(@RequestBody KHPostsDTO KHPostsDTO) {
        KHPostsService.savePost(KHPostsDTO);
        return new ResponseEntity<>("Post saved successfully", HttpStatus.OK);
    }

    @GetMapping("/blogPost1")
    public String getAllPosts(Model model) {
        List<KHPostsDTO> postList = KHPostsService.getAllPosts();
        Set<String> sideTags = KHPostsService.getSideTags(postList);

        // 모델에 데이터 추가
        model.addAttribute("postList", postList);
        model.addAttribute("sideTags", sideTags);
        model.addAttribute("currentPage", "mainPage"); // 현재 페이지 이름 추가

        // 간단한 소개 추가
        String intro = "안녕하세요 주순태입니다.";
        model.addAttribute("intro", intro);

        return "sampleBlogPage_st/blogPost";
    }

    @GetMapping("/blogPost1/editPage")
    public String showEditPage(Model model) {
        model.addAttribute("currentPage", "editPage");
        return "sampleBlogPage_st/blogPost";
    }

    @GetMapping("/blogPost1/readPage")
    public String showReadPage(Model model) {
        List<KHPostsDTO> postList = KHPostsService.getAllPosts();
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "readPage");
        return "sampleBlogPage_st/blogPost";
    }
}
