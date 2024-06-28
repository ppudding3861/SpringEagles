package com.ohgiraffers.springeagles.sejBlog.comment.service;

import com.ohgiraffers.springeagles.global.error.ResourceNotFoundException;
import com.ohgiraffers.springeagles.sejBlog.comment.dto.EJCommentDTO;
import com.ohgiraffers.springeagles.sejBlog.comment.repository.EJCommentEntity;
import com.ohgiraffers.springeagles.sejBlog.comment.repository.EJCommentRepository;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsEntity;
import com.ohgiraffers.springeagles.sejBlog.posts.repository.EJPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EJCommentService {

    private final com.ohgiraffers.springeagles.sejBlog.comment.repository.EJCommentRepository EJCommentRepository;
    private final EJPostsRepository EJPostsRepository;

    // CommentService 생성자
    @Autowired
    public EJCommentService(EJCommentRepository EJCommentRepository, EJPostsRepository EJPostsRepository) {
        this.EJCommentRepository = EJCommentRepository;
        this.EJPostsRepository = EJPostsRepository;
    }

    // 모든 댓글 조회 메서드
    public List<EJCommentDTO> getAllComments() {
        // 모든 댓글을 가져와서 CommentDTO로 변환하여 리스트로 반환
        return EJCommentRepository.findAll().stream()
                .map(EJCommentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // ID로 댓글 조회 메서드
    public Optional<EJCommentDTO> getCommentById(Long id) {
        // ID로 댓글을 조회하여 CommentDTO로 변환하여 Optional로 반환
        return EJCommentRepository.findById(id)
                .map(EJCommentDTO::fromEntity);
    }

    // 댓글 생성 메서드
    public EJCommentDTO createComment(EJCommentDTO EJCommentDTO) {
        // CommentDTO를 CommentEntity로 변환 후 저장하고, 저장된 엔티티를 다시 CommentDTO로 변환하여 반환
        EJCommentEntity entity = EJCommentDTO.toEntity();
        return EJCommentDTO.fromEntity(EJCommentRepository.save(entity));
    }

    // 댓글 수정 메서드
    public EJCommentDTO updateComment(Long id, EJCommentDTO commentDetails) {
        // ID로 댓글을 조회하고 없으면 예외 처리
        EJCommentEntity comment = EJCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));

        // 댓글 내용, 작성일, 수정일, 작성자, 포스트 ID를 업데이트
        comment.setCommentContent(commentDetails.getCommentContent());
        comment.setCreatedDate(commentDetails.getCommentDate());
        comment.setModifiedDate(commentDetails.getCommentModifyTime());
        comment.setCommentAuthor(commentDetails.getCommentAuthor());

        // 업데이트된 댓글을 저장하고 CommentDTO로 변환하여 반환
        return EJCommentDTO.fromEntity(EJCommentRepository.save(comment));
    }

    // 댓글 삭제 메서드
    public void deleteComment(Long id) {
        // ID로 댓글을 조회하고 없으면 예외 처리
        EJCommentEntity comment = EJCommentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found for this id :: " + id));

        // 댓글 삭제
        EJCommentRepository.delete(comment);
    }

    // 포스트 ID에 해당하는 모든 댓글 조회 메서드
    public List<EJCommentDTO> getCommentsByPostId(Long postId) {
        // 해당 포스트 ID에 해당하는 모든 댓글을 가져옴
        EJPostsEntity post = EJPostsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID"));

        List<EJCommentEntity> comments = post.getComments();

        // CommentDTO 리스트로 변환하여 반환
        return comments.stream()
                .map(EJCommentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 댓글 목록을 뷰에 전달하는 메서드
    @GetMapping
    public String viewComments(Model model) {
        // 모든 댓글을 가져와서 CommentDTO 리스트로 변환
        List<EJCommentDTO> comments = getAllComments();

        // 모델에 댓글 목록과 빈 댓글 객체 추가
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new EJCommentDTO()); // 빈 댓글 객체를 모델에 추가

        // 뷰 페이지의 이름을 반환
        return "comments";
    }
}
