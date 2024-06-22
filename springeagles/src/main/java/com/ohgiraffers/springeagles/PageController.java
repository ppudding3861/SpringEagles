package com.ohgiraffers.springeagles;

import com.ohgiraffers.springeagles.common.BlogDTO;
import com.ohgiraffers.springeagles.common.BlogStDAO;
import com.ohgiraffers.springeagles.common.PostSaveDAO;
import com.ohgiraffers.springeagles.common.PostSaveDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class PageController {

    private final BlogStDAO blogStDAO;
    private final PostSaveDAO postSaveDAO;

    // 단일 생성자이므로 @Autowired는 생략 가능
    public PageController(BlogStDAO blogStDAO, PostSaveDAO postSaveDAO) {
        this.blogStDAO = blogStDAO;
        this.postSaveDAO = postSaveDAO;
    }

    @GetMapping("/blogPost1")
    public String blogPost1(Model model) {
        List<PostSaveDTO> postList = postSaveDAO.getAllPosts();
        Set<String> sideTags = postSaveDAO.sideTags(postList);

        model.addAttribute("sideTags", sideTags);
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "mainPage");

        return "sampleBlogPage_st/blogPost";
    }

    @GetMapping("/blogPost1/editPage")
    public String blogPost1EditPage(Model model) {
        model.addAttribute("currentPage", "editPage");
        return "sampleBlogPage_st/blogPost";
    }

    @GetMapping("/blogPost1/readPage")
    public String getAllPosts(Model model) {
        List<PostSaveDTO> postList = postSaveDAO.getAllPosts();
        model.addAttribute("postList", postList);
        model.addAttribute("currentPage", "readPage");
        return "sampleBlogPage_st/blogPost";
    }
}
