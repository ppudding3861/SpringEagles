package com.ohgiraffers.springeagles.jstBlog.posts.service;

import com.ohgiraffers.springeagles.global.user.repository.UserRepository;
import com.ohgiraffers.springeagles.jstBlog.comment.repository.STCommentEntity;
import com.ohgiraffers.springeagles.jstBlog.comment.service.STCommentService;
import com.ohgiraffers.springeagles.jstBlog.likes.service.STLikesService;
import com.ohgiraffers.springeagles.jstBlog.posts.dto.STPostsDTO;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsEntity;
import com.ohgiraffers.springeagles.jstBlog.posts.repository.STPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class STPostsService {

    private final STPostsRepository stPostsRepository;
    private final UserRepository userRepository;
    private final STCommentService stCommentService;
    private final STLikesService stlikesService;

    @Autowired
    public STPostsService(STPostsRepository stPostsRepository, UserRepository userRepository, STCommentService stCommentService, STLikesService stlikesService) {
        this.stPostsRepository = stPostsRepository;
        this.userRepository = userRepository;
        this.stCommentService = stCommentService;
        this.stlikesService = stlikesService;
    }

    // Create
    public STPostsEntity createPost(STPostsDTO stPostsDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        Integer userId = userRepository.findByUserName(username).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없음")).getUserId().intValue();

        stPostsDTO.setUserId(userId);

        STPostsEntity entity = new STPostsEntity(stPostsDTO);
        return stPostsRepository.save(entity);
    }

    // Read
    public List<STPostsEntity> getAllPosts() {
        return stPostsRepository.findAll();
    }

    public Optional<STPostsEntity> getPostById(Integer id) {
        return stPostsRepository.findById(id);
    }

    // Update
    public STPostsEntity updatePost(STPostsDTO stPostsDTO) {
        Integer postId = stPostsDTO.getPostId();

        STPostsEntity entity = stPostsRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("잘못된 게시물 ID:" + postId)
        );

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        Integer userId = userRepository.findByUserName(username).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없음")
        ).getUserId().intValue();

        if (!entity.getUserId().equals(userId)) {
            throw new SecurityException("이 게시물을 업데이트할 권한이 없습니다");
        }

        entity.setTitle(stPostsDTO.getTitle());
        entity.setDescription(stPostsDTO.getDescription());
        entity.setImageUrl(stPostsDTO.getImageUrl());
        entity.setContent(stPostsDTO.getContent());
        return stPostsRepository.save(entity);
    }

    // Delete
    public void deletePost(Integer postId) {
        STPostsEntity entity = stPostsRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("잘못된 게시물 ID:" + postId)
        );

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        Integer userId = userRepository.findByUserName(username).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없음")
        ).getUserId().intValue();

        if (!entity.getUserId().equals(userId)) {
            throw new SecurityException("이 게시물을 삭제할 권한이 없습니다");
        }

        stPostsRepository.deleteById(postId);
    }

    public Map<String, Integer> calculateTagCounts() {
        List<STPostsEntity> posts = stPostsRepository.findAll();
        Map<String, Integer> tagCounts = new HashMap<>();

        for (STPostsEntity post : posts) {
            List<String> tagArray = post.getTagArray();
            for (String tag : tagArray) {
                tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
            }
        }

        return tagCounts;
    }

    public int getCommentCountByPostId(Integer postId) {
        List<STCommentEntity> comments = stCommentService.getCommentsByPost(postId);
        return comments.size();
    }

    public List<STPostsEntity> getAllLikes() {
        List<STPostsEntity> posts = stPostsRepository.findAll();
        for (STPostsEntity post : posts) {
            int likesCount = stlikesService.getLikesCountByPostId(post.getPostId());
            post.setLikesCount(likesCount);
        }
        return posts;
    }
}
