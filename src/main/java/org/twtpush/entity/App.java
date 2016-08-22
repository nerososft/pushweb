package org.twtpush.entity;
import java.util.Date;
/**
 * Created by nero on 16-8-18.
 */
public class App {

    private long appId;

    private String appName;

    private String appKey;

    @Override
    public String toString() {
        return "App{" +
                "appId=" + appId +
                ", appName='" + appName + '\'' +
                ", appKey='" + appKey + '\'' +
                ", appSecretKey='" + appSecretKey + '\'' +
                ", appDeveloperId=" + appDeveloperId +
                ", appType='" + appType + '\'' +
                ", appCompany='" + appCompany + '\'' +
                ", appCreatetime=" + appCreatetime +
                '}';
    }

    private String appSecretKey;

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppCompany() {
        return appCompany;
    }

    public void setAppCompany(String appCompany) {
        this.appCompany = appCompany;
    }

    private long appDeveloperId;
    private String appType;
    private String appCompany;

    public long getAppDeveloperId() {
        return appDeveloperId;
    }

    public void setAppDeveloperId(long appDeveloperId) {
        this.appDeveloperId = appDeveloperId;
    }

    private Date appCreatetime;

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecretKey() {
        return appSecretKey;
    }

    public void setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey;
    }

    public Date getAppCreatetime() {
        return appCreatetime;
    }

    public void setAppCreatetime(Date appCreatetime) {
        this.appCreatetime = appCreatetime;
    }
}
