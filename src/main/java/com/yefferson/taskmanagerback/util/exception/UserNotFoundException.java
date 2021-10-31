package com.yefferson.taskmanagerback.util.exception;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super(ConstanstApiRest.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
