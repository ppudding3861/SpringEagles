package com.ohgiraffers.springeagles.global.follow.model;

import com.google.protobuf.Timestamp;
import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;

public class FollowDTO {

    private UserEntity from_user;
    private UserEntity to_user;
    private Timestamp createDate;

    public FollowDTO() {
    }

    public FollowDTO(UserEntity from_user, UserEntity to_user, Timestamp createDate) {
        this.from_user = from_user;
        this.to_user = to_user;
        this.createDate = createDate;
    }

    public UserEntity getFrom_user() {
        return from_user;
    }

    public void setFrom_user(UserEntity from_user) {
        this.from_user = from_user;
    }

    public UserEntity getTo_user() {
        return to_user;
    }

    public void setTo_user(UserEntity to_user) {
        this.to_user = to_user;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "FollowDTO{" +
                "from_user=" + from_user +
                ", to_user=" + to_user +
                ", createDate=" + createDate +
                '}';
    }
}
