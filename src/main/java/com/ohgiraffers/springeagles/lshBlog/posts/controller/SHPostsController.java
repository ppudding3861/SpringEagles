package com.ohgiraffers.springeagles.lshBlog.posts.controller;

import com.ohgiraffers.springeagles.lshBlog.comment.service.SHCommentService;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import com.ohgiraffers.springeagles.lshBlog.posts.service.SHPostsService;
import com.ohgiraffers.springeagles.lshBlog.posts.model.dto.SHPostsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/lsh/blog")
public class SHPostsController {

    private final SHPostsService SHPostsService;
    private final SHCommentService SHCommentService;

    @Autowired
    public SHPostsController(SHPostsService SHPostsService, SHCommentService SHCommentService) {
        this.SHCommentService = SHCommentService;
        this.SHPostsService = SHPostsService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", SHPostsService.getAllPosts());
        return "lsh_Blog/blogPost5";
    }

    @GetMapping
    public ModelAndView showPage(Model model, ModelAndView mv){
        List<SHPostsEntity> postList = SHPostsService.postsEntityList();

        model.addAttribute("connectPage", "main");

        mv.addObject("postList", postList);
        mv.setViewName("lsh_Blog/blogPost5");

        return mv;
    }
}
