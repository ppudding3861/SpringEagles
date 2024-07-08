package com.ohgiraffers.springeagles.hjhBlog.posts.controller;


import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.service.JHPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/postreader/{postId}")
    public ModelAndView showReadPage(@PathVariable("postId") Integer postId, ModelAndView mv) {
        JHPostsEntity post = jhPostsService.getPostById(postId).orElse(null); // ID로 게시글을 찾음
        mv.addObject("post", post); // 선택된 게시글을 모델앤뷰에 추가
        mv.addObject("selectedId", postId); // 선택된 게시글 ID를 모델앤뷰에 추가
        mv.addObject("currentPage", "postreader"); // 현재 페이지 정보를 모델앤뷰에 추가
        mv.setViewName("hjh_Blog/blogpost6"); // 뷰 이름 설정
        return mv; // 모델앤뷰 객체 반환
    }



}
