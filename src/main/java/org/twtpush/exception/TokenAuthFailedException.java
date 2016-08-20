package org.twtpush.exception;

/**
 * Created by nero on 16-8-19.
 */
public class TokenAuthFailedException extends DeveloperException {
    public TokenAuthFailedException(String message) {
        super(message);
    }

    public TokenAuthFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
