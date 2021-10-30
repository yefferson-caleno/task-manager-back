package com.yefferson.taskmanagerback.util.exception;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;

public class StatusNotFoundException extends Exception {

    public StatusNotFoundException() {
        super(ConstanstApiRest.STATUS_NOT_FOUND);
    }

    public StatusNotFoundException(String message) {
        super(message);
    }
}
