package com.ohgiraffers.springeagles.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PostSaveDAO {

    private final List<PostSaveDTO> postList;

    public PostSaveDAO() {
        postList = new ArrayList<>();
    }

    public void savePost(PostSaveDTO post) {
        postList.add(post);
        System.out.println("Post saved successfully: " + post);
    }

    public List<PostSaveDTO> getAllPosts() {
        return postList;
    }

    public Set<String> sideTags(List<PostSaveDTO> postList) {
        Set<String> tags = new HashSet<>();
        for (PostSaveDTO post : postList) {
            tags.addAll(post.getTagArray());
        }
        return tags;
    }
}
