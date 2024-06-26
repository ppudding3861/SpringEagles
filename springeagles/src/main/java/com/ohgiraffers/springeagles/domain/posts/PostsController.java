package com.ohgiraffers.springeagles.domain.posts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    /**
     * 새로운 게시글을 저장하는 엔드포인트입니다.
     * @param postsDTO 저장할 게시글 정보를 담은 DTO입니다.
     * @return 저장 성공 메시지 문자열
     */
    @PostMapping("/saveMarkdown")
    public String saveMarkdown(@RequestBody PostsDTO postsDTO) {
        postsService.savePost(postsDTO);
        return "Post saved successfully";
    }
}
