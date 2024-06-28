package com.ohgiraffers.springeagles.common;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BlogStDAO {

    private final Map<Integer, BlogDTO> blogMap;

    public BlogStDAO() {
        blogMap = new HashMap<>();

        BlogDTO blog1 = new BlogDTO("자바를 알아보자", "자바 공부1", List.of("java"), "2023-06-01", 10, 5, List.of("java"));
        BlogDTO blog2 = new BlogDTO("자바 스크립트 시작하기", "자바스크립트 공부1", List.of("javascript"), "2023-06-02", 20, 15, List.of("javascript"));
        BlogDTO blog3 = new BlogDTO("스프링 너무 어려움", "스프링 공부1", List.of("spring"), "2023-06-03", 5, 10, List.of("spring"));
        blogMap.put(1, blog1);
    }

    public List<BlogDTO> getAllBlogs() {
        return new ArrayList<>(blogMap.values());
    }

    public List<String> getAllTags() {
        List<String> allTags = new ArrayList<>();
        for (BlogDTO blog : blogMap.values()) {
            allTags.addAll(blog.getSideTags()); // 올바른 방법으로 sideTags를 가져옵니다.
        }
        return allTags;
    }
}
