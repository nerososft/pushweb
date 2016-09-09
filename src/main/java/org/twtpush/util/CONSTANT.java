package org.twtpush.util;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-9
 * time: 下午1:14.
 */
public enum  CONSTANT {
    /**
     * ERRORS
     */
    POLICY_FAILED("Policy Failed"),

    TOKEN_AUTH_FAILED("token auth failed!"),

    PASSWORD_INCORRECT("password incorrect"),

    NOT_APP("not app"),

    NOT_POLICY("not policy"),

    APP_FAILED("app failed"),

    PUSH_FAILED("push failed"),

    DEVELOPER_FAILED("developer failed"),

    /**
     * PAGES
     */
    PAGE_DOWNLOAD("download"),

    PAGE_DOCUMENT("document"),

    PAGE_ABOUT("about"),

    PAGE_COMMUNITY("community"),

    PAGE_LOGIN("login"),

    PAGE_APP("app");

    public String name;

    CONSTANT(String name) {
        this.name = name;
    }

}
