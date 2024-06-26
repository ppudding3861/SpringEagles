package com.ohgiraffers.springeagles;

import com.ohgiraffers.springeagles.common.BlogStDAO;

import com.ohgiraffers.springeagles.common.PostSaveDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/blogPost1")
public class PostController {

    private final BlogStDAO blogStDAO;
    private final PostSaveDAO postSaveDAO;

    public PostController(BlogStDAO blogStDAO, PostSaveDAO postSaveDAO) {
        this.blogStDAO = blogStDAO;
        this.postSaveDAO = postSaveDAO;
    }

    /**
     * 블로그 포스트 목록 페이지를 보여줍니다.
     * @param model 데이터를 뷰에 전달하기 위한 Model 객체입니다.
     * @return 뷰 이름("sampleBlogPage_st/blogPost")
     */
    @GetMapping
    public String getAllPosts(Model model) {
        List<PostSaveDTO> postList = postSaveDAO.getAllPosts();
        Set<String> sideTags = postSaveDAO.sideTags(postList);

        model.addAttribute("sideTags", sideTags);
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "mainPage");

        String intro = "안녕하세요 주순태입니다.";
        model.addAttribute("intro", intro);

        return "sampleBlogPage_st/blogPost";
    }

    /**
     * 블로그 포스트 편집 페이지를 보여줍니다.
     * @param model 데이터를 뷰에 전달하기 위한 Model 객체입니다.
     * @return 뷰 이름("sampleBlogPage_st/blogPost")
     */
    @GetMapping("/editPage")
    public String showEditPage(Model model) {
        model.addAttribute("currentPage", "editPage");
        return "sampleBlogPage_st/blogPost";
    }

    /**
     * 모든 블로그 포스트를 읽기 전용 페이지에서 보여줍니다.
     * @param model 데이터를 뷰에 전달하기 위한 Model 객체입니다.
     * @return 뷰 이름("sampleBlogPage_st/blogPost")
     */
    @GetMapping("/readPage")
    public String showReadPage(Model model) {
        List<PostSaveDTO> postList = postSaveDAO.getAllPosts();
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "readPage");
        return "sampleBlogPage_st/blogPost";
    }
}
