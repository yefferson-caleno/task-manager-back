package com.taskmanagerback.taskmanagerback.util.exception;

public class StateNotFoundException extends Exception {

    public StateNotFoundException() {
        super("Estado de tarea no encontrado");
    }

    public StateNotFoundException(String message) {
        super(message);
    }
}
