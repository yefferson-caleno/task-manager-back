package com.yefferson.taskmanagerback.util.exception;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;

public class LoginNotFoundException extends Exception {
    public LoginNotFoundException() {
        super(ConstanstApiRest.LOGIN_NOT_FOUND_EMAIL);
    }

    public LoginNotFoundException(String message) {
        super(message);
    }
}
