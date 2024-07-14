package com.ohgiraffers.springeagles.sejBlog.posts.controller;

import com.ohgiraffers.springeagles.sejBlog.likes.service.EJLikesService;
import com.ohgiraffers.springeagles.sejBlog.posts.model.dto.EJPostsDTO;
import com.ohgiraffers.springeagles.sejBlog.posts.service.EJPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sej/blog")
public class EJPostsController {

    private EJPostsService ejPostsService;
    private EJLikesService ejLikesService;

    @Autowired
    public EJPostsController(EJPostsService ejPostsService, EJLikesService ejLikesService) {
        this.ejPostsService = ejPostsService;
        this.ejLikesService = ejLikesService;
    }

    // 은진이의 블로그 메인 + 전체조회
    //
    @GetMapping("/posts")
    public ModelAndView post(ModelAndView mv) {
        List<EJPostsDTO> ejPostsDTOList = ejPostsService.getallpost();

        //글 목록을 보여주기 위해 postList에 나의 DTO 를 넣어준다 ( th:each )
        mv.addObject("postList", ejPostsDTOList);

        // 글쓰기를 눌렀을 때 왔다갔다 하기 위해 currentPage 값에 mainPage 를 담아준다.(th:if)
        mv.addObject("currentPage", "mainPage");
        mv.setViewName("sej_Blog/ej_main");
        return mv;
    }

    // edit(글쓰는 창) 을 보여준다
    @GetMapping("/edit")
    public ModelAndView edit() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("currentPage", "editPage");
        mv.setViewName("sej_Blog/ej_main");
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
    @GetMapping("posts/detail/{postId}")
    public ModelAndView detail(@PathVariable("postId") Integer postId, ModelAndView mv) {
        EJPostsDTO ejPostsDTO = ejPostsService.getpost(postId);
//
//
        Map<Integer, Integer> likeCounts = new HashMap<>();
        likeCounts.put(postId, ejLikesService.getLikeCountByPostId(postId));
        int likeCount = ejLikesService.getLikeCountByPostId(postId);

        mv.addObject("currentPage","detailPage");
        mv.addObject("post", ejPostsDTO);
        mv.addObject("likeCounts", likeCounts);
        System.out.println(likeCount);
        mv.setViewName("sej_Blog/ej_main");
        return mv;
    }

    //[수정하기]
    // 수정할 화면을 가져온다. -> 상세조회랑 비슷함!
    // @PathVariable("postId"): url(엔드포인트) 에서 사용된다
    // 메서드 내부에서 Integer postId 를 사용할 수 있다
    @GetMapping("posts/modify/{postId}")
    public ModelAndView modify(@PathVariable("postId") Integer postId, ModelAndView mv) {
        EJPostsDTO ejPostsDTO = ejPostsService.getpost(postId);
        mv.addObject("post", ejPostsDTO);
        mv.addObject("currentPage","modifyPage");
        mv.setViewName("sej_Blog/ej_main");
        return mv;
    }

    // 수정한 내용을 데이터에 저장함
    @PostMapping("posts/modify/{postId}")
    public ModelAndView postModify(@PathVariable("postId") Integer postId, @ModelAttribute EJPostsDTO ejPostsDTO, ModelAndView mv) {
        EJPostsDTO existingPost = ejPostsService.getpost(postId);
        if(existingPost != null) {
            existingPost.setTitle(ejPostsDTO.getTitle());
            existingPost.setContents(ejPostsDTO.getContents());
            ejPostsService.updatePost(existingPost);
        }
        mv.setViewName("redirect:/sej/blog/posts/detail/" + postId );
        return mv;

    }

    @PostMapping("/posts/delete/{postId}")
    public ModelAndView delete(@PathVariable("postId") Integer postId, ModelAndView mv) {
        ejPostsService.deletePost(postId);
        mv.setViewName("redirect:/sej/blog/posts");
        return mv;
    }


}
