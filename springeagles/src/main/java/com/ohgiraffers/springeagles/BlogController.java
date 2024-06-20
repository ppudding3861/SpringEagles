package com.ohgiraffers.springeagles;

import com.ohgiraffers.springeagles.common.Blog5DAO;
import com.ohgiraffers.springeagles.common.BlogDTO;
import com.ohgiraffers.springeagles.common.BlogStDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private Blog5DAO blog5DAO;

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

    @Autowired
    private BlogStDAO blogStDAO;

    @GetMapping("/blogPost")
    public String blogPost(Model model) {
        model.addAttribute("blogPost", model);
        return "sampleBlogPage/blogPost";
    }

    @GetMapping("/blogPost1")
    public ModelAndView blogPost1() {
        List<BlogDTO> boxes = blogStDAO.getAllBlogs();
        List<String> allTags = blogStDAO.getAllTags();
        ModelAndView mv = new ModelAndView("sampleBlogPage_st/blogPost");
        mv.addObject("boxes", boxes);
        mv.addObject("allTags", allTags);
        return mv;
    }

    @GetMapping("/blogPost4")
    public String blogPost4(Model model) {
        model.addAttribute("blogPost4", model);
        return "sampleBlogPage4/blogPost4";
    }

    @GetMapping("/blogPost5")
    public ModelAndView blogPost5(ModelAndView mv) {
        List<BlogDTO> boxex = blog5DAO.getAllBlogs();
        List<String> allTags = blog5DAO.getAllTags();
        mv = new ModelAndView("sampleBlogPageSH/blogPost5");
        mv.addObject("boxex", boxex);
        mv.addObject("allTags", allTags);
        return mv;
    }
}
