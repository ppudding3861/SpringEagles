package com.ohgiraffers.springeagles;

import com.ohgiraffers.springeagles.common.PostSaveDAO;
import com.ohgiraffers.springeagles.common.PostSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostSaveDAO postSaveDAO;

    @PostMapping("/saveMarkdown")
    public String saveMarkdown(@RequestBody PostSaveDTO post) {
        postSaveDAO.savePost(post);
        return "Post saved successfully";
    }
}

