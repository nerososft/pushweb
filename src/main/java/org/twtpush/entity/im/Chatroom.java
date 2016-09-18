package org.twtpush.entity.im;

import java.util.Date;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-17
 * time: 下午11:14.
 */
public class Chatroom {
    private long chatroomId;
    private long appId;
    private long userId;
    private Date chatroomCreateTime;

    public long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getChatroomCreateTime() {
        return chatroomCreateTime;
    }

    public void setChatroomCreateTime(Date chatroomCreateTime) {
        this.chatroomCreateTime = chatroomCreateTime;
    }

    public Chatroom() {
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "chatroomId=" + chatroomId +
                ", appId=" + appId +
                ", userId=" + userId +
                ", chatroomCreateTime=" + chatroomCreateTime +
                '}';
    }
}
