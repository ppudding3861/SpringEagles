package com.ohgiraffers.springeagles.lshBlog.posts.controller;

import com.ohgiraffers.springeagles.lshBlog.comment.service.SHCommentService;
import com.ohgiraffers.springeagles.lshBlog.posts.model.dto.SHPostsDTO;
import com.ohgiraffers.springeagles.lshBlog.posts.model.entity.SHPostsEntity;
import com.ohgiraffers.springeagles.lshBlog.posts.service.SHPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public SHPostsController(SHPostsService shPostsService, SHCommentService SHCommentService) {
        this.SHCommentService = SHCommentService;
        this.SHPostsService = shPostsService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", SHPostsService.postsEntityList());
        return "lsh_Blog/blogPost5";
    }

    @GetMapping
    public ModelAndView showPage(Model model, ModelAndView mv){
        List<SHPostsEntity> postList = SHPostsService.postsEntityList();

//        model.addAttribute("connectPage", "main");

        mv.addObject("postList", postList);
        mv.setViewName("lsh_Blog/blogPost5");

        return mv;
    }

    @GetMapping("/addpost") // 글쓰기 눌렀을 때 /addpost로 매핑해줌
    public String addPost(Model model){
        return "lsh_Blog/fragments/post5_add";
    }

    @PostMapping("/addpost") // 포스트 등록 누르면 데이터를 추가해주고 블로그메인으로 돌려줌
    public ModelAndView postAdd(ModelAndView mv, SHPostsDTO shPostsDTO){

        Integer postId = SHPostsService.save(shPostsDTO);
        mv.addObject("post", shPostsDTO);
        mv.setViewName("/lsh_Blog/blogPost5");
        return mv;

    }



}
