package com.ohgiraffers.springeagles.khsBlog.posts.controller;

import com.ohgiraffers.springeagles.khsBlog.posts.dto.HSPostsDTO;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogPost4")
public class HSPostHsController {

    @Autowired
    private HSPostsRepository hsPostsRepository;

    @GetMapping("/editpagehs")
    public String blogEditPage(Model model){
        model.addAttribute("currentPage", "editpagehs");
        model.addAttribute("postsDTO", new HSPostsDTO());
        return "/sampleBlogPage4/blogPost4";
    }

    @PostMapping("/submit-post")
    public String createArticle(HSPostsDTO form) {
        System.out.println(form.toString());

        // 1. Dto를 Entity 변환
        HSPostsEntity hsPostsEntity = form.toEntity();
        System.out.println(hsPostsEntity.toString());

        // 2. Repository에게 Entity를 DB로 저장하게 함
        HSPostsEntity saved = hsPostsRepository.save(hsPostsEntity);
        System.out.println(saved.toString());

        return "redirect:/blogPost4";
    }

    @GetMapping
    public String blogPost4(Model model) {
        model.addAttribute("blogPost4", model);
        model.addAttribute("currentPage", "main");
        return "sampleBlogPage4/blogPost4";
    }
}
