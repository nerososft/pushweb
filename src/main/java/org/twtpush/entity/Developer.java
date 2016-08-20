package org.twtpush.entity;

import java.util.Date;
/**
 * Created by nero on 16-8-18.
 */
public class Developer {
    private long developerId;

    private String developerName;

    private String developerEmail;

    private String developerPassword;

    private String developerToken;

    @Override
    public String toString() {
        return "Developer{" +
                "developerId=" + developerId +
                ", developerName='" + developerName + '\'' +
                ", developerEmail='" + developerEmail + '\'' +
                ", developerPassword='" + developerPassword + '\'' +
                ", developerToken='" + developerToken + '\'' +
                ", developerCreatetime=" + developerCreatetime +
                '}';
    }

    public long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(long developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    public String getDeveloperPassword() {
        return developerPassword;
    }

    public void setDeveloperPassword(String developerPassword) {
        this.developerPassword = developerPassword;
    }

    public String getDeveloperToken() {
        return developerToken;
    }

    public void setDeveloperToken(String developerToken) {
        this.developerToken = developerToken;
    }

    public Date getDeveloperCreatetime() {
        return developerCreatetime;
    }

    public void setDeveloperCreatetime(Date developerCreatetime) {
        this.developerCreatetime = developerCreatetime;
    }

    private Date developerCreatetime;

}
