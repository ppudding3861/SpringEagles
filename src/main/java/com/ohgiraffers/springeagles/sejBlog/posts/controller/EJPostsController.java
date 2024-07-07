package com.ohgiraffers.springeagles.sejBlog.posts.controller;

import com.ohgiraffers.springeagles.global.index.model.Post;
import com.ohgiraffers.springeagles.sejBlog.posts.model.dto.EJPostsDTO;
import com.ohgiraffers.springeagles.sejBlog.posts.service.EJPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sej/blog")
public class EJPostsController {

    private EJPostsService ejPostsService;

    @Autowired
    public EJPostsController(EJPostsService ejPostsService) {
        this.ejPostsService = ejPostsService;
    }

    // 은진이의 블로그 메인
    @GetMapping("/posts")
    public ModelAndView post() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sej_Blog/ej_main");
        return mv;
    }

    @GetMapping("/edit")
    public ModelAndView edit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sej_Blog/ej_edit");
        return mv;
    }

    // 쓴 글을 저장한다.
    @PostMapping("/edit")
    public ModelAndView editPost(@ModelAttribute EJPostsDTO ejPostsDTO) {
        ejPostsService.savepost(ejPostsDTO);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:sej/blog/posts");
        return mv;
    }


//    // 쓴 글을 전체 조회한다
//    @GetMapping("/posts")
//    public String postList(Model model) {
//        List<EJPostsDTO> ejPostsDTOList = ejPostsService.getallpost();
//        model.addAttribute("postList", ejPostsDTOList);
//        return "sej_Blog/fragments/post";
//
//    }



}
