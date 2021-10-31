package com.yefferson.taskmanagerback.util.exception;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;

public class RoleNotFoundException extends Exception {

    public RoleNotFoundException() {
        super(ConstanstApiRest.ROLE_NOT_FOUND);
    }

    public RoleNotFoundException(String message) {
        super(message);
    }
}
