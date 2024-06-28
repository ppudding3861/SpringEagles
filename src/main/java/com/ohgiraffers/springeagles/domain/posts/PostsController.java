package com.ohgiraffers.springeagles.domain.posts;

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
public class PostsController {

    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/saveMarkdown")
    @ResponseBody
    public ResponseEntity<String> saveMarkdown(@RequestBody PostsDTO postsDTO) {
        postsService.savePost(postsDTO);
        return new ResponseEntity<>("Post saved successfully", HttpStatus.OK);
    }

    @GetMapping("/blogPost1")
    public String getAllPosts(Model model) {
        List<PostsDTO> postList = postsService.getAllPosts();
        Set<String> sideTags = postsService.getSideTags(postList);

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
        List<PostsDTO> postList = postsService.getAllPosts();
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "readPage");
        return "sampleBlogPage_st/blogPost";
    }
}
