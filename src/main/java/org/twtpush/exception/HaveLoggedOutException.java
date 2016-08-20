package org.twtpush.exception;

/**
 * Created by nero on 16-8-19.
 */
public class HaveLoggedOutException extends DeveloperException {
    public HaveLoggedOutException(String message) {
        super(message);
    }

    public HaveLoggedOutException(String message, Throwable cause) {
        super(message, cause);
    }
}
