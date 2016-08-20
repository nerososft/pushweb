package org.twtpush.dto;

import org.twtpush.entity.Developer;

/**
 * Created by nero on 16-8-19.
 */
public class Login {

    private boolean state;

    private String msg;

    private long resultCode;

    private Developer developer;

    public Login(boolean state, String msg, long resultCode) {
        this.state = state;
        this.msg = msg;
        this.resultCode = resultCode;
    }

    public Login(boolean state, String msg, long resultCode, Developer developer) {
        this.state = state;
        this.msg = msg;
        this.resultCode = resultCode;
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "Login{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", resultCode=" + resultCode +
                ", developer=" + developer +
                '}';
    }
}
