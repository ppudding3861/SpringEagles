package com.ohgiraffers.springeagles.khsBlog.posts.controller;

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

    private final HSPostsService hsPostsService; // HSPostsService 클래스의 인스턴스를 주입받기 위한 필드
    private HSPostsDTO savedDTO;

    @Autowired
    public HSPostController(HSPostsService hsPostsService) {
        this.hsPostsService = hsPostsService;
    }



    /**
     * 블로그 등록 페이지를 보여주는 메서드
     * @param model 모델 객체
     * @return 수정 페이지 뷰 이름
     */
    @GetMapping("/editpagehs")
    public String showEditPage(Model model) {
        List<HSPostsEntity> postList = hsPostsService.postsEntityList(); // 모든 게시글 목록을 가져옴
        Collections.reverse(postList); // 게시글 목록을 역순으로 정렬
        model.addAttribute("currentPage", "editpagehs"); // 현재 페이지 정보를 모델에 추가
        model.addAttribute("postList", postList); // 게시글 목록을 모델에 추가
        return "khs_Blog/hsblogPost"; // 뷰 이름 반환
    }

    /**
     * 게시글 목록 페이지를 보여주는 메서드
     * @param keyword 검색어 (옵션)
     * @param model 모델 객체
     * @param mv 모델앤뷰 객체
     * @return 모델앤뷰 객체 반환
     */
    @GetMapping
    public ModelAndView showlistpage(@RequestParam(value = "keyword", required = false) String keyword, Model model, ModelAndView mv) {
        List<HSPostsEntity> postList = hsPostsService.postsEntityList(); // 모든 게시글 목록을 가져옴
        List<HSPostsEntity> searchResults = hsPostsService.searchPosts(keyword);

        Collections.reverse(postList); // 게시글 목록을 역순으로 정렬
        mv.addObject("searchResults", searchResults);
        model.addAttribute("currentPage", "main"); // 현재 페이지 정보를 모델에 추가
        mv.addObject("postList", postList); // 게시글 목록을 모델앤뷰에 추가
        mv.setViewName("khs_Blog/hsblogPost"); // 뷰 이름 설정
        return mv; // 모델앤뷰 객체 반환
    }

    /**
     * 새로운 게시글을 추가하는 메서드
     * @param hsPostsDTO 게시글 DTO
     * @return 리다이렉트 경로
     */
    @PostMapping("/post")
    public ModelAndView addPost(HSPostsDTO hsPostsDTO, ModelAndView mv) {
        if(hsPostsDTO.getTitle() == null || hsPostsDTO.getTitle().equals("")){
            mv.setViewName("redirect:/khs/blog/editpagehs");
            return mv;
        }
        if(hsPostsDTO.getContent() == null || hsPostsDTO.getContent().equals("")){
            mv.setViewName("redirect:/khs/blog/editpagehs");
        }

        int result = hsPostsService.addPost(hsPostsDTO);
        if(result <= 0) {
            mv.setViewName("error/page");
        }else {
            savedDTO = hsPostsDTO;
            mv.setViewName("redirect:/khs/blog");
        }
        return mv;
    }

    /**
     * 특정 게시글을 읽는 페이지를 보여주는 메서드
     * @param post_id 게시글 ID
     * @param mv 모델앤뷰 객체
     * @return 모델앤뷰 객체 반환
     */
    @GetMapping("/postreader/{post_id}")
    public ModelAndView showReadPage(@PathVariable("post_id") Integer post_id, ModelAndView mv) {
        HSPostsEntity post = hsPostsService.getPostById(post_id).orElse(null); // ID로 게시글을 찾음
        List<HSPostsEntity> postList = hsPostsService.postsEntityList(); // 모든 게시글 목록을 가져옴
        Collections.reverse(postList); // 게시글 목록을 역순으로 정렬
        mv.addObject("postList", postList); // 게시글 목록을 모델앤뷰에 추가
        mv.addObject("post", post); // 선택된 게시글을 모델앤뷰에 추가
        mv.addObject("selectedId", post_id); // 선택된 게시글 ID를 모델앤뷰에 추가
        mv.addObject("currentPage", "postreader"); // 현재 페이지 정보를 모델앤뷰에 추가
        mv.setViewName("khs_Blog/hsblogPost"); // 뷰 이름 설정
        return mv; // 모델앤뷰 객체 반환
    }

    /**
     * 게시글을 삭제하는 메서드
     * @param id 게시글 ID
     * @return 리다이렉트 경로
     */
    @GetMapping("/postreader/delete/{id}")
    public String deletePost(@PathVariable("id") Integer id) {
        hsPostsService.deletePost(id); // ID로 게시글을 삭제
        return "redirect:/khs/blog"; // 블로그 메인 페이지로 리다이렉트
    }

    /**
     * 게시글 수정 페이지를 보여주는 메서드
     * @param id 게시글 ID
     * @param mv 모델앤뷰 객체
     * @return 모델앤뷰 객체 반환
     */
    @GetMapping("/postreader/modify/{id}")
    public ModelAndView modifyPage(@PathVariable("id") Integer id, ModelAndView mv) {
        HSPostsEntity post = hsPostsService.getPostById(id).orElse(null); // ID로 게시글을 찾음
        mv.addObject("post", post); // 선택된 게시글을 모델앤뷰에 추가
        mv.addObject("currentPage", "modifypage"); // 현재 페이지 정보를 모델앤뷰에 추가
        mv.setViewName("khs_Blog/hsblogPost"); // 뷰 이름 설정
        return mv; // 모델앤뷰 객체 반환
    }

    /**
     * 게시글을 수정하는 메서드
     * @param id 게시글 ID
     * @param hsPostsDTO 게시글 DTO
     * @return 리다이렉트 경로
     */
    @PostMapping("/postreader/modify/{id}")
    public String modifyPost(@PathVariable("id") Integer id, HSPostsDTO hsPostsDTO) {
        hsPostsService.modifypost(id, hsPostsDTO);
        return "redirect:/khs/blog/postreader/" + id; // 수정된 게시글 페이지로 리다이렉트
    }
}