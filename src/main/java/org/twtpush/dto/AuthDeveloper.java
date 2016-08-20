package org.twtpush.dto;

import org.twtpush.entity.Developer;

/**
 * Created by nero on 16-8-19.
 */
public class AuthDeveloper {
    private boolean isDeveloper;
    private Developer developer;

    public boolean isDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper(boolean developer) {
        isDeveloper = developer;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public AuthDeveloper(boolean isDeveloper, Developer developer) {
        this.isDeveloper = isDeveloper;
        this.developer = developer;
    }
}
