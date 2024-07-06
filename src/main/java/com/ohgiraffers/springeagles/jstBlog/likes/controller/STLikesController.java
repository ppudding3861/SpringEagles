package com.ohgiraffers.springeagles.jstBlog.likes.controller;

import com.ohgiraffers.springeagles.global.user.service.CustomUserDetailsService;
import com.ohgiraffers.springeagles.jstBlog.likes.dto.STLikesDTO;
import com.ohgiraffers.springeagles.jstBlog.likes.service.STLikesService;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stj/blog")
public class STLikesController {

    private final STLikesService stLikesService;
    private final STPostsService stPostsService;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public STLikesController(STLikesService stLikesService, STPostsService stPostsService,
                             CustomUserDetailsService customUserDetailsService) {
        this.stLikesService = stLikesService;
        this.stPostsService = stPostsService;
        this.customUserDetailsService = customUserDetailsService;
    }


    @PostMapping("/likes")
    public ModelAndView likePost(@ModelAttribute STLikesDTO stLikesDTO,ModelAndView mv) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Integer result = stLikesService.likePost(stLikesDTO, username);

        if (result == 1) {
            mv.addObject("message", "좋아요를 눌렀습니다.");
        } else {
            mv.addObject("message", "이미 좋아요를 누르셨습니다.");
        }
        mv.setViewName("redirect:/stj/blog/post/" + stLikesDTO.getPostId());

        return mv;
    }

    @PostMapping("/unlikes")
    public ModelAndView unlikePost(@ModelAttribute STLikesDTO stLikesDTO, ModelAndView mv) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Integer result = stLikesService.unlikePost(stLikesDTO, username);

        if (result == 1) {
            mv.addObject("message", "좋아요를 눌렀습니다.");
        } else {
            mv.addObject("message", "이미 좋아요를 누르셨습니다.");
        }
        mv.setViewName("redirect:/stj/blog/post/" + stLikesDTO.getPostId());

        return mv;
    }
}
