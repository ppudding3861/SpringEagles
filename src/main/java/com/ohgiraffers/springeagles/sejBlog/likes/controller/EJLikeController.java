package com.ohgiraffers.springeagles.sejBlog.likes.controller;


import com.ohgiraffers.springeagles.sejBlog.likes.service.EJLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//좋아요 수를 관리하고 처리하는 컨트롤러이다.
// 좋아요 수를 출력하고 보여주는 건 postController 가 한다.
@RestController
public class EJLikeController {

    private EJLikesService ejLikesService;

    @Autowired
    public EJLikeController(EJLikesService ejLikesService) {
        this.ejLikesService = ejLikesService;
    }

    // 1. 서비스 레이어에서 좋아요를 증가시키는 함수를 실행한다(likePost)
    // 2. 서비스 레이어에서 좋아요를 조회하는 함수를 실행한다.
    // 3. 그 좋아요를 변수에 넣는다
    // 4. 데이터를 보내기 위해 Map 형태의 response를 정의하고
    // 5. response 에 키값과 좋아요 수 데이터를 보내준다.
    @PostMapping("/sej/blog/posts/detail/{postId}/like")
    public ResponseEntity<Map<String, Integer>> likePost(@PathVariable("postId") Integer postId) {


            ejLikesService.likePost(postId);
            int likeCount = ejLikesService.getLikeCountByPostId(postId);
            Map<String, Integer> response = new HashMap<>();
            response.put("likes", likeCount);

            return ResponseEntity.ok(response);



    }



}
