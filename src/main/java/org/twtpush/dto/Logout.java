package org.twtpush.dto;

/**
 * Created by nero on 16-8-19.
 */
public class Logout {
    private boolean state;

    private String msg;

    private long resultCode;

    public Logout(boolean state, String msg, long resultCode) {
        this.state = state;
        this.msg = msg;
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "Logout{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", resultCode=" + resultCode +
                '}';
    }
}
