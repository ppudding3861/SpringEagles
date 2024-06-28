package com.ohgiraffers.springeagles.jstBlog.posts.controller;

import com.ohgiraffers.springeagles.jstBlog.posts.dto.STPostsDTO;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("blog")
public class STPostsController {

    private final STPostsService STPostsService;

    @Autowired
    public STPostsController(STPostsService STPostsService) {
        this.STPostsService = STPostsService;
    }

    @GetMapping("stjoo/mainPage")
    public String getAllPosts(Model model) {
        List<STPostsDTO> postList = STPostsService.getAllPosts();
        Set<String> sideTags = STPostsService.getSideTags(postList);
        // 모델에 데이터 추가
        model.addAttribute("postList", postList);
        model.addAttribute("sideTags", sideTags);
        model.addAttribute("currentPage", "mainPage"); // 현재 페이지 이름 추가
        // 간단한 소개 추가
        String intro = "안녕하세요 주순태입니다.";
        model.addAttribute("intro", intro);

        return "jst_Blog/blogPost";
    }

    @GetMapping("stjoo/editPage")
    public String showEditPage(Model model) {
        model.addAttribute("currentPage", "editPage");
        return "jst_Blog/blogPost";
    }

    @GetMapping("stjoo/readPage")
    public String showReadPage(Model model) {
        List<STPostsDTO> postList = STPostsService.getAllPosts();
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "readPage");
        return "jst_Blog/blogPost";
    }

    @PostMapping("/saveMarkdown")
    @ResponseBody
    public ResponseEntity<String> saveMarkdown(@RequestBody STPostsDTO STPostsDTO) {
        STPostsService.savePost(STPostsDTO);
        return new ResponseEntity<>("Post saved successfully", HttpStatus.OK);
    }
}
