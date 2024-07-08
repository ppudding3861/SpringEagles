package com.ohgiraffers.springeagles.hjhBlog.posts.controller;


import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.service.JHPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/hjh/blog")
public class JHPostsController {

    private final JHPostsService jhPostsService;
    private  Object jhPostsEntity;

    @Autowired
    public JHPostsController(JHPostsService jhPostsService) {
        this.jhPostsService = jhPostsService;
    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", jhPostsService.getAllPosts());
        return "/hjh_Blog/blogpost6";
    }

    @GetMapping("/post")
    public String showEditPage(Model model) {
        model.addAttribute("currentPage", "Add");
        return "/hjh_Blog/blogpost6";
    }

    @PostMapping("/add")
    public ModelAndView createPost(JHPostsDTO jhPostsDTO, ModelAndView mv) {

        Integer result = jhPostsService.add(jhPostsDTO);
        String message = null;
        if(result <= 0){
            message = "등록실패";
            mv.addObject("message","등록실패");
            mv.setViewName("redirect:/hjh/blog/post");

        }else{
            message = "등록성공";
            mv.setViewName("redirect:/hjh/blog/posts");
        }
        mv.addObject("message", message);
        return mv;

    }
    @GetMapping
    public ModelAndView showlistpage(Model model, ModelAndView mv ) {

        List<JHPostsEntity> postList = jhPostsService.postsEntityList();

        Collections.reverse(postList);
        model.addAttribute("currentPage", "list");

        mv.addObject("postList", postList);
        mv.setViewName("hjh/Blog/blogPost6");

        return mv;
    }
    @GetMapping("/postreader/{postId}")
    public ModelAndView showReadPage(@PathVariable("postId") Integer postId, ModelAndView mv) {
        JHPostsEntity post = jhPostsService.getPostById(postId).orElse(null);

        mv.addObject("post", post);
        mv.addObject("selectedId",postId);
        mv.addObject("currentPage", "postreader");
        mv.setViewName("hjh/Blog/blogPost6");
        return mv;
    }
    @GetMapping("/postreader/delete")
    public String deletePost(@RequestParam("id") Integer id) {
        jhPostsService.deletePost(id);
        return "redirect:/hjh/Blog/blogPost6";
    }

    @GetMapping("/postreader/modify{id}")
    public ModelAndView modifyPage(@PathVariable("id") Integer id, ModelAndView mv) {
        JHPostsEntity post = jhPostsService.getPostById(id).orElse(null);
        mv.addObject("post", post);
        mv.addObject("currentPage", "modifypage");
        mv.setViewName("hjh/Blog/blogPost6");
        return mv;
    }




}
