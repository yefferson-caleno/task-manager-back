package com.taskmanagerback.taskmanagerback.util.exception;

public class TeamNotFoundException extends Exception {

    public TeamNotFoundException() {
        super("Equipo no encontrada");
    }

    public TeamNotFoundException(String message) {
        super(message);
    }
}
