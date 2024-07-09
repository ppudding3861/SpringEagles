package com.ohgiraffers.springeagles.jstBlog.comment.controller;

import com.ohgiraffers.springeagles.jstBlog.comment.model.STReplyDTO;
import com.ohgiraffers.springeagles.jstBlog.comment.service.STReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/stj/blog/reply")
public class STReplyController {

    private final STReplyService stReplyService;

    @Autowired
    public STReplyController(STReplyService stReplyService) {
        this.stReplyService = stReplyService;
    }

    // 대댓글 생성
    @PostMapping("/create")
    public ModelAndView createReply(@ModelAttribute STReplyDTO replyDTO,
                                    @RequestParam Integer postId,
                                    ModelAndView mv) {
        int result = stReplyService.createReply(replyDTO);
        if (result == 1) {
            mv.setViewName("redirect:/stj/blog/post/" + postId);
            return mv;
        } else {
            mv.addObject("errorMessage", "대댓글 작성 실패");
            mv.setViewName("redirect:/stj/blog/post/" + postId);
            return mv;
        }
    }

    // 대댓글 수정
    @PostMapping("/update/{replyId}")
    public ModelAndView updateReply(@ModelAttribute STReplyDTO replyDTO,
                                    @RequestParam Integer postId,
                                    ModelAndView mv) {
        if (replyDTO.getContent() == null || replyDTO.getContent().trim().isEmpty()) {
            mv.addObject("errorMessage", "댓글이 없습니다");
            mv.setViewName("redirect:/stj/blog/post/" + postId);
            return mv;
        }
        int result = stReplyService.updateReply(replyDTO);
        if (result == 1) {
            mv.setViewName("redirect:/stj/blog/post/" + postId);
        } else {
            mv.addObject("errorMessage", "대댓글 수정 실패");
            mv.setViewName("redirect:/stj/blog/post/" + postId);
        }
        return mv;
    }

    // 대댓글 삭제
    @PostMapping("/delete/{replyId}")
    public ModelAndView deleteReply(@ModelAttribute STReplyDTO replyDTO,
                                    @RequestParam Integer postId,
                                    ModelAndView mv) {
        int result = stReplyService.deleteReply(replyDTO);
        if (result == 1) {
            mv.setViewName("redirect:/stj/blog/post/" + postId); // 성공 시 리다이렉트
        } else {
            mv.addObject("errorMessage", "대댓글 삭제 실패");
            mv.setViewName("redirect:/stj/blog/post/" + postId); // 실패 시 오류 페이지로 이동
        }
        return mv;
    }
}
