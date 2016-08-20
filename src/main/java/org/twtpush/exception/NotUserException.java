package org.twtpush.exception;

/**
 * Created by nero on 16-8-19.
 */
public class NotUserException extends DeveloperException {
    public NotUserException(String message) {
        super(message);
    }

    public NotUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
