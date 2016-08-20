package org.twtpush.exception;

/**
 * Created by nero on 16-8-19.
 */
public class DeveloperException extends RuntimeException {
    public DeveloperException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeveloperException(String message) {
        super(message);
    }
}
