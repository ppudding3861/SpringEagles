package com.ohgiraffers.springeagles.sejBlog.posts.controller;

import com.ohgiraffers.springeagles.sejBlog.posts.model.dto.EJPostsDTO;
import com.ohgiraffers.springeagles.sejBlog.posts.service.EJPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    // 은진이의 블로그 메인 + 전체조회
    //
    @GetMapping("/posts")
    public ModelAndView post(ModelAndView mv) {
        List<EJPostsDTO> ejPostsDTOList = ejPostsService.getallpost();
        mv.addObject("postList", ejPostsDTOList);
        mv.setViewName("sej_Blog/ej_main");
        return mv;
    }

    // edit(글쓰는 창) 을 보여준다
    //
    @GetMapping("/edit")
    public ModelAndView edit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sej_Blog/ej_edit");
        return mv;
    }

    // 쓴 글을 저장한다.
    @PostMapping("/edit")
    public ModelAndView editPost(@ModelAttribute EJPostsDTO ejPostsDTO, ModelAndView mv) {
        ejPostsService.savepost(ejPostsDTO);
        mv.setViewName("redirect:/sej/blog/posts");
        return mv;
    }

    // [상세조회]
    // 1. 수정할 화면을 가져온다.(상세조회)
    // 2. 리소스 : edit + pathvalue
    // 3. 블로그 서비스에서 getpost 함수를 통해 데이터를 가져오고 dto 에 담는다.
    // 4. detail 이라는 화면에 데이터를 넣어주는데 - 그 떄 "post"라는 키값을 사용한다.
    // 5. 그리고 그 view 를 반환하여 보여준다.
    @GetMapping("posts/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id, ModelAndView mv) {
        EJPostsDTO ejPostsDTO = ejPostsService.getpost(id);
        mv.addObject("post", ejPostsDTO);
        mv.setViewName("sej_Blog/ej_detail");
        return mv;
    }

    //[수정하기]
    // 수정할 화면을 가져온다. -> 상세조회랑 비슷함!
    @GetMapping("posts/modify/{id}")
    public ModelAndView modify(@PathVariable Integer id, ModelAndView mv) {
        EJPostsDTO ejPostsDTO = ejPostsService.getpost(id);
        mv.addObject("post", ejPostsDTO);
        mv.setViewName("sej_Blog/ej_modify");
        return mv;
    }

    // 수정한 내용을 데이터에 저장함
    @PostMapping("posts/modify/{id}")
    public ModelAndView postModify(@PathVariable Integer id, @ModelAttribute EJPostsDTO ejPostsDTO, ModelAndView mv) {
        EJPostsDTO existingPost = ejPostsService.getpost(id);
        if(existingPost != null) {
            existingPost.setTitle(ejPostsDTO.getTitle());
            existingPost.setContents(ejPostsDTO.getContents());
            ejPostsService.updatePost(existingPost);
        }
        mv.setViewName("redirect:/sej/blog/posts/detail/" + id );
        return mv;

    }

    @PostMapping("/posts/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id, ModelAndView mv) {
        ejPostsService.deletPost(id);
        mv.setViewName("redirect:/sej/blog/posts");
        return mv;
    }


}
