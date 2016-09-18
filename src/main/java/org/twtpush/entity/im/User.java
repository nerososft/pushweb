package org.twtpush.entity.im;

import java.util.Date;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-17
 * time: 下午11:04.
 */
public class User {
    private long userId;
    private long appId;
    private Date userCreateTime;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", appId=" + appId +
                ", userCreateTime=" + userCreateTime +
                '}';
    }
}
