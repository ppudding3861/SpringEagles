package com.ohgiraffers.springeagles.jstBlog.comment.controller;

import com.ohgiraffers.springeagles.global.auth.util.handler.CustomAccessDeniedHandler;
import com.ohgiraffers.springeagles.jstBlog.comment.model.STCommentDTO;
import com.ohgiraffers.springeagles.jstBlog.comment.service.STCommentService;
import com.ohgiraffers.springeagles.jstBlog.posts.service.STPostsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
@RequestMapping("/stj/blog")
public class STCommentController {

    private final STPostsService stPostsService;
    private final STCommentService stCommentService;
    private final CustomAccessDeniedHandler accessDeniedHandler;


    @Autowired
    public STCommentController(STCommentService stCommentService,
                               STPostsService stPostsService,
                               CustomAccessDeniedHandler accessDeniedHandler) {
        this.stCommentService = stCommentService;
        this.stPostsService = stPostsService;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    // 댓글 저장 관련 로직
    @PostMapping("/savecomment")
    public ModelAndView saveComment(@ModelAttribute STCommentDTO stCommentDTO, ModelAndView mv) {
        int result = stCommentService.saveComment(stCommentDTO);
        if (result <= 0) {
            mv.addObject("errorMessage", "댓글 저장에 실패했습니다.");
            mv.setViewName("redirect:/stj/blog/post/" + stCommentDTO.getPostId());
        } else {
            mv.setViewName("redirect:/stj/blog/post/" + stCommentDTO.getPostId());
        }
        return mv;
    }

    // 삭제 관련 로직
    @PostMapping("/deletecomment")
    public ModelAndView deleteComment(@ModelAttribute STCommentDTO stCommentDTO, HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws IOException {
        try {
            int result = stCommentService.deleteCommentById(stCommentDTO);
            if (result <= 0) {
                mv.addObject("errorMessage", "댓글 삭제에 실패했습니다.");
            }
        } catch (SecurityException e) {
            accessDeniedHandler.handle(request, response, new AccessDeniedException(e.getMessage()));
            return null;
        }
        mv.setViewName("redirect:/stj/blog/post/" + stCommentDTO.getPostId());
        return mv;
    }


    // 수정 관련 로직
    @PostMapping("/updatecomment")
    public ModelAndView updateComment(@ModelAttribute STCommentDTO stCommentDTO, HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws IOException {
        try {
            int result = stCommentService.updateComment(stCommentDTO);
            if (result <= 0) {
                mv.addObject("errorMessage", "댓글 수정에 실패했습니다.");
            }
        } catch (SecurityException e) {
            accessDeniedHandler.handle(request, response, new AccessDeniedException(e.getMessage()));
            return null;
        }
        mv.setViewName("redirect:/stj/blog/post/" + stCommentDTO.getPostId());
        return mv;
    }
}
