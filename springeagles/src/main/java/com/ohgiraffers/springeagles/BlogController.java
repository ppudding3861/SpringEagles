package com.ohgiraffers.springeagles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();

        // Sample data
        posts.add(new Post("주순태", "프로그램 천재", "/images/sample01.jpeg", "#"));
        posts.add(new Post("김기호", "그만 아프길...", "/images/sample02.png", "#"));
        posts.add(new Post("서은진", "잘빠진 기획안 내놔라!!!", "/images/sample03.png", "#"));
        posts.add(new Post("강형석", "팀장이다", "/images/sample04.png", "#"));
        posts.add(new Post("황정한", "잘생겼따!황정한", "/images/sample04.png", "#"));
        posts.add(new Post("이서현", "이글스는 이제 그만...", "/images/sample04.png", "#"));
        // Add more posts as needed

        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/blogPost")
    public String blogPost(Model model) {
        model.addAttribute("blogPost", model);
        return "sampleBlogPage/blogPost";
    }
    @GetMapping("/blogPost4")
    public String blogPost4(Model model) {
        model.addAttribute("blogPost4", model);
        return "sampleBlogPage4/blogPost4";
    }
}
