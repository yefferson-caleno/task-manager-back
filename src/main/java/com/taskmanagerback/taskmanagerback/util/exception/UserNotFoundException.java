package com.taskmanagerback.taskmanagerback.util.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("Usuario no encontrado");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
