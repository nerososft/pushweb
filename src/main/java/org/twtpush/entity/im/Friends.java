package org.twtpush.entity.im;

import java.util.Date;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-17
 * time: 下午11:58.
 */
public class Friends {
    private long appId;
    private long userAId;
    private long userBId;
    private long userAPass;
    private long userBPass;
    private Date friendCreateTime;
    private Date friendBeTime;

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public long getUserAId() {
        return userAId;
    }

    public void setUserAId(long userAId) {
        this.userAId = userAId;
    }

    public long getUserBId() {
        return userBId;
    }

    public void setUserBId(long userBId) {
        this.userBId = userBId;
    }

    public long getUserAPass() {
        return userAPass;
    }

    public void setUserAPass(long userAPass) {
        this.userAPass = userAPass;
    }

    public long getUserBPass() {
        return userBPass;
    }

    public void setUserBPass(long userBPass) {
        this.userBPass = userBPass;
    }

    public Date getFriendCreateTime() {
        return friendCreateTime;
    }

    public void setFriendCreateTime(Date friendCreateTime) {
        this.friendCreateTime = friendCreateTime;
    }

    public Date getFriendBeTime() {
        return friendBeTime;
    }

    public void setFriendBeTime(Date friendBeTime) {
        this.friendBeTime = friendBeTime;
    }

    public Friends() {
    }

    @Override
    public String toString() {
        return "Friends{" +
                "appId=" + appId +
                ", userAId=" + userAId +
                ", userBId=" + userBId +
                ", userAPass=" + userAPass +
                ", userBPass=" + userBPass +
                ", friendCreateTime=" + friendCreateTime +
                ", friendBeTime=" + friendBeTime +
                '}';
    }
}
