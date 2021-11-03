package com.yefferson.taskmanagerback.util.exception;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;

public class TeamNotFoundException extends Exception {
    public TeamNotFoundException() {
    super(ConstanstApiRest.TEAM_NOT_FOUND);
    }

    public TeamNotFoundException(String message) {
        super(message);
    }
}
