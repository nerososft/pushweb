package org.twtpush.exception;

/**
 * Created by nero on 16-8-20.
 */
public class NotAppException extends DeveloperException {
    public NotAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAppException(String message) {
        super(message);
    }
}
