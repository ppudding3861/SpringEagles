package com.ohgiraffers.springeagles.khsBlog.posts.controller;

import com.ohgiraffers.springeagles.khsBlog.posts.dto.HSPostsDTO;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsEntity;
import com.ohgiraffers.springeagles.khsBlog.posts.repository.HSPostsRepository;
import com.ohgiraffers.springeagles.khsBlog.posts.service.HSPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/khs/blog")
public class HSPostController {

    private HSPostsService hsPostsService;
    private HSPostsRepository hsPostsRepository;

    @Autowired
    public HSPostController(HSPostsRepository hsPostsRepository, HSPostsService hSPostsService) {
        this.hsPostsRepository = hsPostsRepository;
        this.hsPostsService = hSPostsService;
    }

    @GetMapping("/editpagehs")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_KHS')")
    public String showEditPage(Model model) {
        model.addAttribute("currentPage", "editpagehs");
        return "khs_Blog/blogPost4";
    }

    @GetMapping
    public ModelAndView showlistpage(Model model, ModelAndView mv ) {

        List<HSPostsEntity> postList = hsPostsService.postsEntityList();

        Collections.reverse(postList);

        model.addAttribute("currentPage", "main");

        mv.addObject("postList", postList);
        mv.setViewName("khs_Blog/blogPost4");

        return mv;
    }

    @PostMapping("/post")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_KHS')")
    public String addPost(HSPostsDTO hsPostsDTO) {

        HSPostsEntity hsPostsEntity = hsPostsDTO.toEntity();
        HSPostsEntity saved = hsPostsRepository.save(hsPostsEntity);
        System.out.println(saved.toString());
        return "redirect:/khs/blog";
    }

    @GetMapping("/postreader/{post_id}")
    public ModelAndView showReadPage(@PathVariable("post_id") Integer post_id, ModelAndView mv) {
        HSPostsEntity post = hsPostsService.getPostById(post_id).orElse(null);
        mv.addObject("post", post);
        mv.addObject("selectedId",post_id);
        mv.addObject("currentPage", "postreader");
        mv.setViewName("khs_Blog/blogPost4");
        return mv;
    }

    @GetMapping("/postreader/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_KHS')")
    public String deletePost(@PathVariable("id") Integer id) {
        hsPostsService.deletePost(id);
        return "redirect:/khs/blog";
    }

    @GetMapping("/postreader/modify/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_KHS')")
    public ModelAndView modifyPage(@PathVariable("id") Integer id, ModelAndView mv) {
        HSPostsEntity post = hsPostsService.getPostById(id).orElse(null);
        mv.addObject("post", post);
        mv.addObject("currentPage", "modifypage");
        mv.setViewName("khs_Blog/blogPost4");
        return mv;
    }

    @PostMapping("/postreader/modify/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_KHS')")
    public String modifyPost(@PathVariable("id") Integer id, HSPostsDTO hsPostsDTO) {
        HSPostsEntity updatedEntity = hsPostsDTO.toEntity();
        hsPostsService.modifypost(id, updatedEntity);
        return "redirect:/khs/blog/postreader/" + id;
    }

}
