package com.ohgiraffers.springeagles.common;

import java.util.List;

public class BlogDTO {

    private String title;
    private String description;
    private List<String> tags;
    private String date;
    private int commentsCount;
    private int likesCount;
    private List<String> sideTags;

    public BlogDTO() {
    }

    public BlogDTO(String title, String description, List<String> tags, String date, int commentsCount, int likesCount, List<String> sideTags) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.date = date;
        this.commentsCount = commentsCount;
        this.likesCount = likesCount;
        this.sideTags = sideTags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public List<String> getSideTags() {
        return sideTags;
    }

    public void setSideTags(List<String> sideTags) {
        this.sideTags = sideTags;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                ", date='" + date + '\'' +
                ", commentsCount=" + commentsCount +
                ", likesCount=" + likesCount +
                ", sideTags=" + sideTags +
                '}';
    }
}
