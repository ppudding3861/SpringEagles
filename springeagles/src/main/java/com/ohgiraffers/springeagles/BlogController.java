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
        posts.add(new Post("PD들의 브랜드 디깅법", "워디즈 PD의 브랜드 디깅법", "/images/sample01.jpeg", "#"));
        posts.add(new Post("프로젝트 디자인", "서울 경험을 설계하는 프로젝트디자인", "/images/sample02.png", "#"));
        posts.add(new Post("와디즈란?", "필요한건 여기서 다 만든다", "/images/sample03.png", "#"));
        posts.add(new Post("여름이닷!!", "마지막 이미지다", "/images/sample04.png", "#"));
        // Add more posts as needed

        model.addAttribute("posts", posts);
        return "index";
    }
}
