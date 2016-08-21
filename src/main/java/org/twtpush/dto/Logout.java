package org.twtpush.dto;

/**
 * Created by nero on 16-8-19.
 */
public class Logout {
    private boolean state;

    private String msg;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getResultCode() {
        return resultCode;
    }

    public void setResultCode(long resultCode) {
        this.resultCode = resultCode;
    }

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
