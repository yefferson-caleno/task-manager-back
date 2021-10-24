package com.taskmanagerback.taskmanagerback.util.exception;

public class TaskNotFoundException extends Exception {

    public TaskNotFoundException() {
        super("Tarea no encontrada");
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
