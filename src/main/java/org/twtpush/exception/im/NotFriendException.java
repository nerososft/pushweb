package org.twtpush.exception.im;

import org.twtpush.exception.DeveloperException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-18
 * time: 上午8:27.
 */
public class NotFriendException extends DeveloperException {
    public NotFriendException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFriendException(String message) {
        super(message);
    }
}
