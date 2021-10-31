package com.yefferson.taskmanagerback.util.exception;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException() {
        super(ConstanstApiRest.TASK_NOT_FOUND);
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
