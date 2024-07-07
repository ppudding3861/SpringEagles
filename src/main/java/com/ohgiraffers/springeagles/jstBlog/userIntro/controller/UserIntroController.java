package com.ohgiraffers.springeagles.jstBlog.userIntro.controller;

import com.ohgiraffers.springeagles.jstBlog.userIntro.model.UserIntroDTO;
import com.ohgiraffers.springeagles.jstBlog.userIntro.service.UserIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/stj/blog")
public class UserIntroController {

    private final UserIntroService userIntroService;

    @Autowired
    public UserIntroController(UserIntroService userIntroService) {
        this.userIntroService = userIntroService;
    }

    @PostMapping("/updateIntro")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_STJ')")
    @ResponseBody
    public Map<String, String> updateIntro(@RequestBody UserIntroDTO userIntroDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            int result = userIntroService.saveOrUpdateIntroContent(userIntroDTO);
            if (result == 1) {
                response.put("message", "소개글 저장이 완료 되었습니다");
            } else if (result == 2) {
                response.put("message", "소개글 수정이 완료 되었습니다");
            }
        } catch (IllegalArgumentException e) {
            response.put("message", "소개글 저장 혹은 수정에 실패하였습니다: " + e.getMessage());
        } catch (Exception e) {
            response.put("message", "알 수 없는 오류가 발생하였습니다: " + e.getMessage());
        }
        return response;
    }
}