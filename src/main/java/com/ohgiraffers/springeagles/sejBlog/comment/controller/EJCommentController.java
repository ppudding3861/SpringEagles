package com.ohgiraffers.springeagles.sejBlog.comment.controller;

import org.springframework.stereotype.Controller;

@Controller
public class EJCommentController {

//    private final EJCommentService EJCommentService;
//
//    @Autowired
//    public EJCommentController(EJCommentService EJCommentService) {
//        this.EJCommentService = EJCommentService;
//    }
//
//    @GetMapping
//    public String index(){
//        return "blogpost5";
//    }
//
//    @PostMapping
//    public ModelAndView commentBlog(EJCommentDTO EJCommentDTO, ModelAndView mv){
//
//        if(EJCommentDTO.getCommentContent() == null || EJCommentDTO.getCommentContent().equals("")){
//            mv.setViewName("redirect:/");
//        }
//
//        int result = EJCommentService.comment(EJCommentDTO);
//        if(result <= 0){
//            mv.setViewName("error/page");
//        }else{
//            mv.setViewName("blogpost5");
//        }
//        return mv;
//    }
}
