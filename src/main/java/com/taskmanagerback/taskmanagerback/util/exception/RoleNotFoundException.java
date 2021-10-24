package com.taskmanagerback.taskmanagerback.util.exception;

public class RoleNotFoundException extends Exception {

    public RoleNotFoundException() {
        super("Rol no encontrado");
    }

    public RoleNotFoundException(String message) {
        super(message);
    }
}
