package org.twtpush.entity;

import java.util.Date;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-4
 * time: 下午4:09.
 */
public class Policy {
    private long policyId;
    private long appId;
    private  String policyName;

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", appId=" + appId +
                ", policyName='" + policyName + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    private Date createTime;


    public Policy() {
    }

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

}
