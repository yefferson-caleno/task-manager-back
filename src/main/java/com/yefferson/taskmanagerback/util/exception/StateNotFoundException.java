package com.yefferson.taskmanagerback.util.exception;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;

public class StateNotFoundException extends Exception {
    public StateNotFoundException() {
        super(ConstanstApiRest.STATE_NOT_FOUND);
    }

    public StateNotFoundException(String message) {
        super(message);
    }
}
