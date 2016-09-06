package org.twtpush.exception;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-6
 * time: 下午1:03.
 */
public class NotPolicyException extends DeveloperException {

    public NotPolicyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotPolicyException(String message) {
        super(message);
    }
}
