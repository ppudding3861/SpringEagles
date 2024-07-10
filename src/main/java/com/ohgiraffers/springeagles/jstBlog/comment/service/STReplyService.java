package com.ohgiraffers.springeagles.jstBlog.comment.service;

import com.ohgiraffers.springeagles.jstBlog.comment.entity.STCommentEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.entity.STReplyEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.model.STReplyDTO;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentRepository;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class STReplyService {

    private final STReplyRepository stReplyRepository;
    private final STCommentRepository stCommentRepository;

    @Autowired
    public STReplyService(STReplyRepository stReplyRepository,
                          STCommentRepository stCommentRepository) {
        this.stReplyRepository = stReplyRepository;
        this.stCommentRepository = stCommentRepository;
    }


    // 댓글에 대한 대댓글 가져오기
    public List<STReplyEntity> getRepliesByCommentId(Integer commentId) {
        Optional<STCommentEntity> comment = stCommentRepository.findById(commentId);
        if (comment.isPresent()) {
            return stReplyRepository.findByCommentCommentId(commentId);
        } else {
            throw new RuntimeException("Comment not found");
        }
    }

    // 인증중인 유저의 아이디 가져오기
    private String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    // 대댓글 생성
    @Transactional
    public Integer createReply(STReplyDTO replyDTO) {
        if (replyDTO.getCommentId() == null || replyDTO.getContent() == null) {
            return 0;
        }

        STReplyEntity reply = new STReplyEntity();

        Optional<STCommentEntity> comment = stCommentRepository.findById(replyDTO.getCommentId());
        if (comment.isPresent()) {
            reply.setComment(comment.get());
        } else {
            throw new RuntimeException("Comment not found");
        }

        if (replyDTO.getParentReplyId() != null) {
            Optional<STReplyEntity> parentReply = stReplyRepository.findById(replyDTO.getParentReplyId());
            if (parentReply.isPresent()) {
                reply.setParentReply(parentReply.get());
                reply.setDepth(parentReply.get().getDepth() + 1); // 부모 대댓글의 뎁스 + 1
            } else {
                throw new RuntimeException("Parent reply not found");
            }
        } else {
            reply.setDepth(1); // 최상위 댓글의 뎁스는 0
        }

        String username = getCurrentUsername();
        reply.setUsername(username);

        reply.setContent(replyDTO.getContent());
        reply.setCreatedDate(LocalDate.now());
        stReplyRepository.save(reply);
        return 1;
    }

    // 대댓글 수정
    @Transactional
    public Integer updateReply(STReplyDTO replyDTO) {
        if (replyDTO.getReplyId() == null || replyDTO.getContent() == null) {
            return 0;
        }

        Optional<STReplyEntity> reply = stReplyRepository.findById(replyDTO.getReplyId());
        if (reply.isPresent()) {
            reply.get().setContent(replyDTO.getContent());
            stReplyRepository.save(reply.get());
            return 1;
        } else {
            throw new RuntimeException("Reply not found");
        }
    }

    // 대댓글 삭제
    @Transactional
    public Integer deleteReply(STReplyDTO replyDTO) {
        if (replyDTO.getReplyId() == null) {
            return 0;
        }

        Optional<STReplyEntity> reply = stReplyRepository.findById(replyDTO.getReplyId());
        if (reply.isPresent()) {
            stReplyRepository.delete(reply.get());
            return 1;
        } else {
            return 0;
        }
    }
}
