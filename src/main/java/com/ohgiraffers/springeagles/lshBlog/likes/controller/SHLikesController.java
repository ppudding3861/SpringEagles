package com.ohgiraffers.springeagles.lshBlog.likes.controller;

import com.ohgiraffers.springeagles.lshBlog.likes.service.SHLikesService;
import com.ohgiraffers.springeagles.lshBlog.likes.model.dto.SHLikesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogposts")
public class SHLikesController {

    private final SHLikesService SHLikesService;

    @Autowired
    public SHLikesController(SHLikesService SHLikesService) {
        this.SHLikesService = SHLikesService;
    }

    @GetMapping
    public String index(){
        return "blogpost5/";
    }

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
