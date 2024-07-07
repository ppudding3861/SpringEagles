package com.ohgiraffers.springeagles.global.follow.entity;

import com.google.protobuf.Timestamp;
import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "global_follow")
public class FollowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id", nullable = false)
    private Integer followId;

    @ManyToOne
    @JoinColumn(name = "from_user")
    private UserEntity from_user;

    @ManyToOne
    @JoinColumn(name = "to_user")
    private UserEntity to_user;

    @CreationTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    public FollowEntity() {
    }

    public FollowEntity(Integer followId, UserEntity from_user, UserEntity to_user, Timestamp createDate) {
        this.followId = followId;
        this.from_user = from_user;
        this.to_user = to_user;
        this.createDate = createDate;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
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
        return "FollowEntity{" +
                "followId=" + followId +
                ", from_user=" + from_user +
                ", to_user=" + to_user +
                ", createDate=" + createDate +
                '}';
    }
}
