package com.ohgiraffers.springeagles.domain.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogPost4")
public class PostHsController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/editpagehs")
    public String blogEditPage(Model model){
        model.addAttribute("currentPage", "editpagehs");
        model.addAttribute("postsDTO", new PostsDTO());
        return "/sampleBlogPage4/blogPost4";
    }

    @PostMapping("/submit-post")
    public String createArticle(PostsDTO form) {
        System.out.println(form.toString());

        // 1. Dto를 Entity 변환
        PostsEntity postsEntity = form.toEntity();
        System.out.println(postsEntity.toString());

        // 2. Repository에게 Entity를 DB로 저장하게 함
        PostsEntity saved = postsRepository.save(postsEntity);
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
