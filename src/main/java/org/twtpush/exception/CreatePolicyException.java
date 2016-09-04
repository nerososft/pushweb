package org.twtpush.exception;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-4
 * time: 下午6:00.
 */
public class CreatePolicyException  extends DeveloperException{
    public CreatePolicyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatePolicyException(String message) {
        super(message);
    }
}
