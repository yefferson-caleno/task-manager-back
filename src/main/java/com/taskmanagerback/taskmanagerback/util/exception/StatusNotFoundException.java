package com.taskmanagerback.taskmanagerback.util.exception;

public class StatusNotFoundException extends Exception {

    public StatusNotFoundException() {
        super("Estado de información no encontrado");
    }

    public StatusNotFoundException(String message) {
        super(message);
    }
}
