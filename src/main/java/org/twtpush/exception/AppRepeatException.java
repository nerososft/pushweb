package org.twtpush.exception;

/**
 * Created by nero on 16-8-21.
 */
public class AppRepeatException extends DeveloperException {
    public AppRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppRepeatException(String message) {
        super(message);
    }
}
