package com.ohgiraffers.springeagles;

import com.ohgiraffers.springeagles.common.BlogDTO;
import com.ohgiraffers.springeagles.common.BlogStDAO;
import com.ohgiraffers.springeagles.common.PostSaveDAO;
import com.ohgiraffers.springeagles.common.PostSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private BlogStDAO blogStDAO;

    @Autowired
    private PostSaveDAO postSaveDAO;

    @GetMapping("/blogPost1")
    public String blogPost1(Model model) {
        List<BlogDTO> boxes = blogStDAO.getAllBlogs();
        List<String> allTags = blogStDAO.getAllTags();
        model.addAttribute("boxes", boxes);
        model.addAttribute("allTags", allTags);
        model.addAttribute("currentPage", "mainPage");
        return "sampleBlogPage_st/blogPost";
    }

    @GetMapping("/blogPost1/editPage")
    public String blogPost1EditPage(Model model) {
        model.addAttribute("currentPage", "editPage");
        return "sampleBlogPage_st/blogPost";
    }


    @GetMapping("/blogPost1/readPage")
    public String getAllPosts(Model model) {
        List<PostSaveDTO> postList = postSaveDAO.getAllPosts();
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "readPage");
        return "sampleBlogPage_st/blogPost";
    }
}