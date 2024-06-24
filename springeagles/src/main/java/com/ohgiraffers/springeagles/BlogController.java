package com.ohgiraffers.springeagles;

import com.ohgiraffers.springeagles.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();

        // Sample data
        posts.add(new Post("주순태", "프로그램 천재", "/images/sample01.jpeg", "#"));
        posts.add(new Post("김기호", "Long learner", "/images/blogPost3Logo.jpg", "#"));
        posts.add(new Post("서은진", "잘빠진 기획안 내놔라!!!", "/images/sample022.png", "#"));
        posts.add(new Post("강형석", "팀장이다", "/images/springmasct.png", "#"));
        posts.add(new Post("황정한", "잘생겼따!황정한", "/images/sample04.png", "#"));
        posts.add(new Post("이서현", "Hanwhaeagles_Soori", "/images/soori.png", "#"));
        // Add more posts as needed

        model.addAttribute("posts", posts);
        return "index";
    }

    @Autowired
    private Blog2DAO blog2DAO;

    @GetMapping("/blogPost2")
    public ModelAndView blogPost2() {
        List<BlogDTO> boxes = blog2DAO.getAllBlogs();
        List<String> allTags = blog2DAO.getAllTags();
        ModelAndView mv = new ModelAndView("sampleBlogPage2/blogPost2");
        mv.addObject("boxes", boxes);
        mv.addObject("allTags", allTags);

        return mv;
    }


    @GetMapping("/blogPost3")
    public String blogPost3(Model model) {
        model.addAttribute("blogPost3", model);
        return "sampleBlogPage3/blogPost3";
    }


    @GetMapping("/blogPost4")
    public String blogPost4(Model model) {
        model.addAttribute("blogPost4", model);
        return "sampleBlogPage4/blogPost4";
    }

    @Autowired
    private Blog5DAO blog5DAO;

    @GetMapping("/blogPost5")
    public ModelAndView blogPost5(ModelAndView mv) {
        List<BlogDTO> boxex = blog5DAO.getAllBlogs();
        List<String> allTags = blog5DAO.getAllTags();
        mv = new ModelAndView("sampleBlogPageSH/blogPost5");
        mv.addObject("boxex", boxex);
        mv.addObject("allTags", allTags);
        return mv;
    }

    @Autowired
    private Blog5DAO Blog6JHDAO;

    @GetMapping("/blogPost6")
    public ModelAndView blogPost6() {
        List<BlogDTO> boxes = Blog6JHDAO.getAllBlogs();
        List<String> allTags = Blog6JHDAO.getAllTags();
        ModelAndView mv = new ModelAndView("sampleBlogPage_JH/blogPost6");
        mv.addObject("boxes", boxes);
        mv.addObject("allTags", allTags);
        return mv;
    }
}
