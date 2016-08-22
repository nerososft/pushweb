package org.twtpush.dto;

/**
 * Created by nero on 16-8-21.
 */
public class DeveloperInfo {
    private String developerName;
    private String developerEmail;
    private String developerToken;

    public DeveloperInfo(String developerName, String developerEmail, String developerToken, long developerId) {
        this.developerName = developerName;
        this.developerEmail = developerEmail;
        this.developerToken = developerToken;
        this.developerId = developerId;
    }

    @Override

    public String toString() {
        return "DeveloperInfo{" +
                "developerName='" + developerName + '\'' +
                ", developerEmail='" + developerEmail + '\'' +
                ", developerToken='" + developerToken + '\'' +
                ", developerId=" + developerId +
                '}';
    }

    public String getDeveloperToken() {
        return developerToken;
    }

    public void setDeveloperToken(String developerToken) {
        this.developerToken = developerToken;
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

    public long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(long developerId) {
        this.developerId = developerId;
    }

    private long developerId;

}
