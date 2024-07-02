package com.ohgiraffers.springeagles.lshBlog.comment.controller;

import com.ohgiraffers.springeagles.lshBlog.comment.service.SHCommentService;
import com.ohgiraffers.springeagles.lshBlog.comment.model.dto.SHCommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogpost5")
public class SHCommentController {

    private final SHCommentService SHCommentService;

    @Autowired
    public SHCommentController(SHCommentService SHCommentService) {
        this.SHCommentService = SHCommentService;
    }

    @GetMapping
    public String index(){
        return "blogpost5";
    }

    @PostMapping
    public ModelAndView commentBlog(SHCommentDTO SHCommentDTO, ModelAndView mv){

        if(SHCommentDTO.getCommentContent() == null || SHCommentDTO.getCommentContent().equals("")){
            mv.setViewName("redirect:/");
        }

        int result = SHCommentService.comment(SHCommentDTO);
        if(result <= 0){
            mv.setViewName("error/page");
        }else{
            mv.setViewName("blogpost5");
        }
        return mv;
    }
}
