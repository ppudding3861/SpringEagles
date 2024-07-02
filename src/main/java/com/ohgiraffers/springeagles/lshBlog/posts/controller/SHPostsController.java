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

//    @GetMapping("/posts/{id}")
//    public String getPostById(@PathVariable("id") Integer postsId, Model model) {
//        SHPostsEntity post = SHPostsService.
//    }
//
//    @PostMapping
//    public ModelAndView postBlog(SHPostsDTO SHPostsDTO, ModelAndView mv){
//
//        if(SHPostsDTO.getTitle() == null || SHPostsDTO.getTitle().equals("")){
//            mv.setViewName("redirect:/");
//        }
//        if(SHPostsDTO.getContents() == null || SHPostsDTO.getContents().equals("")){
//            mv.setViewName("redirect:/");
//        }
//        int result = SHPostsService.post(SHPostsDTO);
//        if(result <= 0){
//            mv.setViewName("error/page");
//        }else{
//            mv.setViewName("/lsh/blog");
//        }
//        return mv;
//    }
}
