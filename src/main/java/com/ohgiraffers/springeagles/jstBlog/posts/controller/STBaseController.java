package com.ohgiraffers.springeagles.jstBlog.posts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@Controller
public class STBaseController {

    @ModelAttribute("isLiked")
    public boolean isLiked(Integer postId, Model model) {
        Map<Integer, Boolean> likeStatuses = (Map<Integer, Boolean>) model.getAttribute("likeStatuses");
        return likeStatuses != null && likeStatuses.getOrDefault(postId, false);
    }
}
