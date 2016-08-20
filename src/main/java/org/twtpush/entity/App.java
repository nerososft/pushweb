package org.twtpush.entity;
import java.util.Date;
/**
 * Created by nero on 16-8-18.
 */
public class App {

    private long appId;

    private String appName;

    private String appKey;

    private String appSecretKey;
    private long appDeveloperId;

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

    @Override
    public String toString() {
        return "App{" +
                "appId=" + appId +
                ", appName='" + appName + '\'' +
                ", appKey='" + appKey + '\'' +
                ", appSecretKey='" + appSecretKey + '\'' +
                ", appDeveloperId=" + appDeveloperId +
                ", appCreatetime=" + appCreatetime +
                '}';
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
