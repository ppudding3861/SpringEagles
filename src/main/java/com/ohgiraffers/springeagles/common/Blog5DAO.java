package com.ohgiraffers.springeagles.common;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Blog5DAO {

    private final Map<Integer, BlogDTO> blogMap;

    public Blog5DAO() {
        blogMap = new HashMap<>();

        BlogDTO blog1 = new BlogDTO("일단 테스트 하는거야", "이게 내용?", List.of("java"), "2023-06-01", 10, 5, List.of("java"));
        BlogDTO blog2 = new BlogDTO("두번째 포스트 테스트", "잘 나오려나", List.of("javascript"), "2023-06-02", 20, 15, List.of("javascript"));
        BlogDTO blog3 = new BlogDTO("갓순태감사합니다", "잘 나오겠지뭐", List.of("spring"), "2023-06-03", 5, 10, List.of("spring"));
        blogMap.put(1, blog1);
        blogMap.put(2, blog2);
        blogMap.put(3, blog3);
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
