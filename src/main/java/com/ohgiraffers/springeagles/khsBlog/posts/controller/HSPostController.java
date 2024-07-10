package com.ohgiraffers.springeagles.khsBlog.posts.controller;

import com.ohgiraffers.springeagles.khsBlog.likes.service.HSLikeService;
import com.ohgiraffers.springeagles.khsBlog.posts.dto.HSPostsDTO;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.service.HSPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/khs/blog")
public class HSPostController {

    private final HSPostsService hsPostsService;
    private final HSLikeService hsLikeService;

    @Autowired
    public HSPostController(HSPostsService hsPostsService, HSLikeService hsLikeService) {
        this.hsPostsService = hsPostsService;
        this.hsLikeService = hsLikeService;
    }

    @GetMapping("/editpagehs")
    public String showEditPage(Model model) {
        List<HSPostsEntity> postList = hsPostsService.postsEntityList();
        Collections.reverse(postList);
        model.addAttribute("currentPage", "editpagehs");
        model.addAttribute("postList", postList);
        return "khs_Blog/hsblogPost";
    }

    @GetMapping
    public ModelAndView showlistpage(@RequestParam(value = "keyword", required = false) String keyword, Model model, ModelAndView mv) {
        List<HSPostsEntity> postList = hsPostsService.postsEntityList();
        List<HSPostsEntity> searchResults = hsPostsService.searchPosts(keyword);
        Collections.reverse(postList);
        mv.addObject("searchResults", searchResults);
        model.addAttribute("currentPage", "main");
        mv.addObject("postList", postList);
        mv.setViewName("khs_Blog/hsblogPost");
        return mv;
    }

    @PostMapping("/post")
    public ModelAndView addPost(HSPostsDTO hsPostsDTO, ModelAndView mv) {
        if (hsPostsDTO.getTitle() == null || hsPostsDTO.getTitle().isEmpty()) {
            mv.setViewName("redirect:/khs/blog/editpagehs");
            return mv;
        }
        if (hsPostsDTO.getContent() == null || hsPostsDTO.getContent().isEmpty()) {
            mv.setViewName("redirect:/khs/blog/editpagehs");
        }

        int result = hsPostsService.addPost(hsPostsDTO);
        if (result <= 0) {
            mv.setViewName("error/page");
        } else {
            mv.setViewName("redirect:/khs/blog");
        }
        return mv;
    }

    @GetMapping("/postreader/{post_id}")
    public ModelAndView showReadPage(@PathVariable("post_id") Integer post_id, ModelAndView mv) {
        HSPostsEntity post = hsPostsService.getPostById(post_id).orElse(null);
        List<HSPostsEntity> postList = hsPostsService.postsEntityList();
        Collections.reverse(postList);
        mv.addObject("postList", postList);
        mv.addObject("post", post);
        mv.addObject("selectedId", post_id);
        mv.addObject("likeCount", hsLikeService.getLikes(post_id));
        mv.addObject("currentPage", "postreader");
        mv.setViewName("khs_Blog/hsblogPost");
        return mv;
    }

    @GetMapping("/postreader/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        hsPostsService.deletePost(id);
        return "redirect:/khs/blog";
    }

    @GetMapping("/postreader/modify/{id}")
    public ModelAndView modifyPage(@PathVariable("id") Integer id, ModelAndView mv) {
        HSPostsEntity post = hsPostsService.getPostById(id).orElse(null);
        mv.addObject("post", post);
        mv.addObject("currentPage", "modifypage");
        mv.setViewName("khs_Blog/hsblogPost");
        return mv;
    }

    @PostMapping("/postreader/modify/{id}")
    public String modifyPost(@PathVariable("id") Integer id, HSPostsDTO hsPostsDTO) {
        hsPostsService.modifypost(id, hsPostsDTO);
        return "redirect:/khs/blog/postreader/" + id;
    }


}
