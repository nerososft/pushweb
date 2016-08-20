package org.twtpush.exception;

/**
 * Created by nero on 16-8-21.
 */
public class CreateAppException extends DeveloperException
{
    public CreateAppException(String message) {
        super(message);
    }

    public CreateAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
