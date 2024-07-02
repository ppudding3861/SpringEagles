package com.ohgiraffers.springeagles.hjhBlog.posts.service;

import com.ohgiraffers.springeagles.global.user.repository.UserRepository;
import com.ohgiraffers.springeagles.hjhBlog.posts.dto.JHPostsDTO;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsEntity;
import com.ohgiraffers.springeagles.hjhBlog.posts.repository.JHPostsRepository;
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
public class JHPostsService {

    private final JHPostsRepository jhPostsRepository;
    private final UserRepository userRepository;

    @Autowired
    public JHPostsService(JHPostsRepository stPostsRepository, UserRepository userRepository) {
        this.jhPostsRepository = stPostsRepository;
        this.userRepository = userRepository;
    }

    // Create
    // 새 게시물을 생성합니다. 현재 인증된 사용자의 사용자 ID를 게시물에 설정합니다.
    public JHPostsEntity createPost(JHPostsDTO stPostsDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증된 사용자의 정보를 가져옵니다.
        UserDetails userDetails = (UserDetails) authentication.getPrincipal(); // 사용자의 정보를 가져옵니다.
        String username = userDetails.getUsername(); // 사용자의 이름을 가져옵니다.

        Integer userId = userRepository.findByUserName(username).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없음")).getUserId().intValue(); // 사용자의 ID를 가져옵니다.

        stPostsDTO.setUserId(userId); // 게시물의 사용자 ID를 설정합니다.

        JHPostsEntity entity = new JHPostsEntity(stPostsDTO); // DTO를 Entity로 변환합니다.
        return jhPostsRepository.save(entity); // 게시물을 저장하고 반환합니다.
    }

    // Read
    // 모든 게시물을 조회합니다.
    public List<JHPostsEntity> getAllPosts() {
        return jhPostsRepository.findAll(); // 모든 게시물을 반환합니다.
    }

    // ID로 게시물을 조회합니다.
    public Optional<JHPostsEntity> getPostById(Integer id) {
        return jhPostsRepository.findById(id); // ID로 게시물을 조회하고 반환합니다.
    }

    // Update
// 게시물을 업데이트합니다. 현재 인증된 사용자가 게시물의 작성자인지 확인합니다.
    public JHPostsEntity updatePost(JHPostsDTO stPostsDTO) {
        Integer postId = stPostsDTO.getPostId(); // STPostsDTO에서 postId 가져오기

        JHPostsEntity entity = jhPostsRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("잘못된 게시물 ID:" + postId)
        ); // 특정 ID를 가진 STPostsEntity를 찾고, 만약 찾을 수 없다면 예외를 발생시키는 역할을 합니다.

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증된 사용자의 정보를 가져옵니다.
        UserDetails userDetails = (UserDetails) authentication.getPrincipal(); // 사용자의 정보를 가져옵니다.
        String username = userDetails.getUsername(); // 사용자의 이름을 가져옵니다.

        Integer userId = userRepository.findByUserName(username).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없음")
        ).getUserId().intValue(); // 현재 인증된 사용자의 이름을 이용하여 사용자를 찾고, 해당 사용자를 찾을 수 없다면 사용자를 찾을수 없다는 예외를 발생시킵니다.

        if (!entity.getUserId().equals(userId)) {
            throw new SecurityException("이 게시물을 업데이트할 권한이 없습니다"); // 게시물의 작성자가 아닌 경우 예외를 발생시킵니다.
        }

        entity.setTitle(stPostsDTO.getTitle()); // 게시물의 제목을 설정합니다.
        entity.setDescription(stPostsDTO.getDescription()); // 게시물의 설명을 설정합니다.
        entity.setImageUrl(stPostsDTO.getImageUrl()); // 게시물의 이미지 URL을 설정합니다.
        entity.setContent(stPostsDTO.getContent()); // 게시물의 내용을 설정합니다.
        return jhPostsRepository.save(entity); // 게시물을 저장하고 반환합니다.
    }


    // Delete
    // 게시물을 삭제합니다. 현재 인증된 사용자가 게시물의 작성자인지 확인합니다.
    public void deletePost(Integer postId) {
        JHPostsEntity entity = jhPostsRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("잘못된 게시물 ID:" + postId)
        ); // 특정 ID를 가진 STPostsEntity를 찾고, 만약 찾을 수 없다면 예외를 발생시키는 역할을 합니다.

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증된 사용자의 정보를 가져옵니다.
        UserDetails userDetails = (UserDetails) authentication.getPrincipal(); // 사용자의 정보를 가져옵니다.
        String username = userDetails.getUsername(); // 사용자의 이름을 가져옵니다.

        Integer userId = userRepository.findByUserName(username).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없음")
        ).getUserId().intValue(); // 현재 인증된 사용자의 이름을 이용하여 사용자를 찾고, 해당 사용자를 찾을 수 없다면 사용자를 찾을수 없다는 예외를 발생시킵니다.

        if (!entity.getUserId().equals(userId)) {
            throw new SecurityException("이 게시물을 삭제할 권한이 없습니다"); // 게시물의 작성자가 아닌 경우 예외를 발생시킵니다.
        }

        jhPostsRepository.deleteById(postId); // 게시물을 삭제합니다.
    }

    public Map<String, Integer> calculateTagCounts() {
        List<JHPostsEntity> posts = jhPostsRepository.findAll();
        Map<String, Integer> tagCounts = new HashMap<>();

        for (JHPostsEntity post : posts) {
            List<String> tagArray = post.getTagArray();
            for (String tag : tagArray) {
                tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
            }
        }

        return tagCounts;
    }
}
