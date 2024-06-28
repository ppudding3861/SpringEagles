package com.ohgiraffers.springeagles.lshBlog.comment.service;

import com.ohgiraffers.springeagles.global.error.ResourceNotFoundException;
import com.ohgiraffers.springeagles.lshBlog.comment.dto.SHCommentDTO;
import com.ohgiraffers.springeagles.lshBlog.comment.repository.SHCommentEntity;
import com.ohgiraffers.springeagles.lshBlog.comment.repository.SHCommentRepository;
import com.ohgiraffers.springeagles.lshBlog.posts.repository.SHPostsEntity;
import com.ohgiraffers.springeagles.lshBlog.posts.repository.SHPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SHCommentService {

    private final com.ohgiraffers.springeagles.lshBlog.comment.repository.SHCommentRepository SHCommentRepository;
    private final SHPostsRepository SHPostsRepository;

    // CommentService 생성자
    @Autowired
    public SHCommentService(SHCommentRepository SHCommentRepository, SHPostsRepository SHPostsRepository) {
        this.SHCommentRepository = SHCommentRepository;
        this.SHPostsRepository = SHPostsRepository;
    }

    // 모든 댓글 조회 메서드
    public List<SHCommentDTO> getAllComments() {
        // 모든 댓글을 가져와서 CommentDTO로 변환하여 리스트로 반환
        return SHCommentRepository.findAll().stream()
                .map(SHCommentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // ID로 댓글 조회 메서드
    public Optional<SHCommentDTO> getCommentById(Long id) {
        // ID로 댓글을 조회하여 CommentDTO로 변환하여 Optional로 반환
        return SHCommentRepository.findById(id)
                .map(SHCommentDTO::fromEntity);
    }

    // 댓글 생성 메서드
    public SHCommentDTO createComment(SHCommentDTO SHCommentDTO) {
        // CommentDTO를 CommentEntity로 변환 후 저장하고, 저장된 엔티티를 다시 CommentDTO로 변환하여 반환
        SHCommentEntity entity = SHCommentDTO.toEntity();
        return SHCommentDTO.fromEntity(SHCommentRepository.save(entity));
    }

    // 댓글 수정 메서드
    public SHCommentDTO updateComment(Long id, SHCommentDTO commentDetails) {
        // ID로 댓글을 조회하고 없으면 예외 처리
        SHCommentEntity comment = SHCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));

        // 댓글 내용, 작성일, 수정일, 작성자, 포스트 ID를 업데이트
        comment.setCommentContent(commentDetails.getCommentContent());
        comment.setCreatedDate(commentDetails.getCommentDate());
        comment.setModifiedDate(commentDetails.getCommentModifyTime());
        comment.setCommentAuthor(commentDetails.getCommentAuthor());

        // 업데이트된 댓글을 저장하고 CommentDTO로 변환하여 반환
        return SHCommentDTO.fromEntity(SHCommentRepository.save(comment));
    }

    // 댓글 삭제 메서드
    public void deleteComment(Long id) {
        // ID로 댓글을 조회하고 없으면 예외 처리
        SHCommentEntity comment = SHCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));

        // 댓글 삭제
        SHCommentRepository.delete(comment);
    }

    // 포스트 ID에 해당하는 모든 댓글 조회 메서드
    public List<SHCommentDTO> getCommentsByPostId(Long postId) {
        // 해당 포스트 ID에 해당하는 모든 댓글을 가져옴
        SHPostsEntity post = SHPostsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID"));

        List<SHCommentEntity> comments = post.getComments();

        // CommentDTO 리스트로 변환하여 반환
        return comments.stream()
                .map(SHCommentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 댓글 목록을 뷰에 전달하는 메서드
    @GetMapping
    public String viewComments(Model model) {
        // 모든 댓글을 가져와서 CommentDTO 리스트로 변환
        List<SHCommentDTO> comments = getAllComments();

        // 모델에 댓글 목록과 빈 댓글 객체 추가
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new SHCommentDTO()); // 빈 댓글 객체를 모델에 추가

        // 뷰 페이지의 이름을 반환
        return "comments";
    }
}
