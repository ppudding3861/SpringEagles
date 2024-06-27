package com.ohgiraffers.springeagles.domain.posts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/blogPost4")
public class PostHsController {

    @GetMapping
    public String blogPost4(Model model) {
        model.addAttribute("blogPost4", model);
        model.addAttribute("currentPage", "main");
        return "sampleBlogPage4/blogPost4";
    }


    @GetMapping("/editpagehs")
    public String blogEditPage(Model model){
        model.addAttribute("currentPage", "editpagehs");
        return "/sampleBlogPage4/blogPost4";
    }
//    @GetMapping("blogPost4/main")
//    public String mainpages(Model model){
//
//        return "/sampleBlogPage4/blogPost4";
//    }
}
