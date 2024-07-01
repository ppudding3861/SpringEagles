package com.ohgiraffers.springeagles.global.index;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        List<Post> posts = new ArrayList<>();

        // Sample data
        posts.add(new Post("주순태", "프로그래밍 초심자", "/images/sample01.jpeg", "#"));
        posts.add(new Post("서은진", "잘빠진 기획안 내놔라!!!", "/images/sej_main_img.png", "#"));
        posts.add(new Post("김기호", "Long learner", "/images/kkh_user_img.jpg", "#"));
        posts.add(new Post("강형석", "팀장이다", "/images/khs_main_img.png", "#"));
        posts.add(new Post("이서현", "Hanwhaeagles_Soori", "/images/lsh_main_img.png", "#"));
        posts.add(new Post("황정한", "잘생겼따!황정한", "/images/sample04.png", "#"));
        // Add more posts as needed

        model.addAttribute("posts", posts);
        model.addAttribute("username", authentication.getName());
        return "index";
    }
}
