package com.ohgiraffers.springeagles.sejBlog.likes.controller;

import com.ohgiraffers.springeagles.sejBlog.likes.service.EJLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping("/blogposts")
public class EJSLikesController {

    private final EJLikesService EJLikesService;

    @Autowired
    public EJSLikesController(EJLikesService EJLikesService) {
        this.EJLikesService = EJLikesService;
    }

//    @GetMapping
//    public String index(){
//        return "blogpost5/";
//    }

//    @PostMapping
//    public ModelAndView postBlog(SHLikesDTO SHLikesDTO, ModelAndView mv){

        // Likes는 카운팅을 해야하는데 이게 필요가 있나?

        //
//        if(SHLikesDTO.getTitle() == null || SHPostsDTO.getTitle().equals("")){
//            mv.setViewName("redirect:/");
//        }
//        if(SHPostsDTO.getContents() == null || SHPostsDTO.getContents().equals("")){
//            mv.setViewName("redirect:/");
//        }
//        int result = SHPostsService.post(SHPostsDTO);
//        if(result <= 0){
//            mv.setViewName("error/page");
//        }else{
//            mv.setViewName("index/blogpost5");
//        }
//        return mv;
//    }
}
