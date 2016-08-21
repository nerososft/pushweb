package org.twtpush.dto;

/**
 * ajax retuen type,[json]
 * Created by nero on 16-8-19.
 */
public class Result<T> {
    private boolean success;

    private T data;

    private String error;

    public Result(boolean success,T data) {
        this.data = data;
        this.success = success;
        this.error=null;
    }

    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
        this.data=null;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
