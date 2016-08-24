package org.twtpush.exception;

/**
 * Created by nero on 16-8-24.
 */
public class NotAppOwnerException extends DeveloperException {
    public NotAppOwnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAppOwnerException(String message) {
        super(message);
    }
}
