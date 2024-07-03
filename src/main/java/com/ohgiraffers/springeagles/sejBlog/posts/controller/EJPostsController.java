package com.ohgiraffers.springeagles.sejBlog.posts.controller;

import com.ohgiraffers.springeagles.sejBlog.comment.service.EJCommentService;
import com.ohgiraffers.springeagles.sejBlog.posts.service.EJPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sej/blog")
public class EJPostsController {

    private final EJPostsService EJPostsService;
    private final EJCommentService EJCommentService;

    @Autowired
    public EJPostsController(EJPostsService EJPostsService, EJCommentService EJCommentService) {
        this.EJCommentService = EJCommentService;
        this.EJPostsService = EJPostsService;
    }

    @GetMapping("/posts")
    public String main(Model model) {
        model.addAttribute("posts", EJPostsService.getAllPosts());
        return "sej_Blog/blogPost2";
    }

    @GetMapping("/edit")
    public String editor() {
        return "sej_Blog/fragments/blogPost2_editor";
    }


//    @GetMapping
//    public ModelAndView showPage(Model model, ModelAndView mv){
//        List<EJPostsEntity> postList = EJPostsService.postsEntityList();
//        // 잘하면 수정해야할 수도? "connectPage?"
//        model.addAttribute("connectPage", "main");
//
//        mv.addObject("postList", postList);
//        mv.setViewName("sej_Blog/blogPost2");
//
//        return mv;
//    }
//
//
//    @GetMapping("/editor")
//    public String addPost(Model model){
//        return "sej_Blog/fragments/addPost";
//    }
//
//    @PostMapping("/addpost")
//    public ModelAndView postAdd(ModelAndView mv, EJPostsDTO EJPostsDTO){
//
//        // 등록시킬 데이터
//
//        mv.setViewName("이동할 페이지");
//
//        return mv;
//
//    }



}
