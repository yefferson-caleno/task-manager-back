package com.yefferson.taskmanagerback.config;

public class ConstanstApiRest {

    public static final String HEALTH_MSG = "¡El servicio 'Task Maganer' se encuentra disponible!";

    // Request MSG.
    public static final String NOT_BLANK_TEAM_DESCRIPTION = "Debe agregar un nombre al equipo";
    public static final String NOT_NULL_TEAM_STATUS = "Debe agregar un estado al equipo";
    public static final String NOT_BLANK_USER_NAME = "Debe agregar el nombre del usuario";
    public static final String NOT_BLANK_USER_EMAIL = "Debe agregar un correo al usuario";
    public static final String NOT_BLANK_USER_PASSWORD = "Debe agregar una contraseña al usuario";
    public static final String NOT_NULL_USER_ROLE = "Debe agregar un rol al usuario";
    public static final String NOT_NULL_USER_TEAM = "Debe agregar un equipo al usuario";
    public static final String NOT_NULL_USER_STATUS = "Debe agregar un estado al usuario";
    public static final String NOT_BLANK_TASK_TITLE = "Debe ingresar el titulo de la tarea";
    public static final String NOT_NULL_TASK_TEAM = "Debe agregar un equipo a la tarea";
    public static final String NOT_NULL_TASK_USER_ASSIGNED = "Debe asignar un usuario a la tarea";
    public static final String NOT_BLANK_TASK_USER_CREATED = "Debe registrar el usuario que creó la tarea";
    public static final String NOT_NULL_TASK_STATE = "Debe agregar un estado de progreso a la tarea";
    public static final String NOT_NULL_TASK_STATUS = "Debe activar/desactivar la tarea";
    public static final String NOT_BLANK_LOGIN_EMAIL = "Debe ingresar el correo registrado";
    public static final String NOT_BLANK_LOGIN_PASSWORD = "Debe ingresar la contraseña registrada";

    // Exception MSG.
    public static final String INVALID_PARAMS = "¡Par\u00e1metros de entrada invalidos!";
    public static final String STATUS_NOT_FOUND = "Estado de informaci\u00f3n no encontrado";
    public static final String TEAM_NOT_FOUND = "No se ha encontrado la informaci\u00f3n del equipo";
    public static final String ROLE_NOT_FOUND = "No se ha encontrado la informaci\u00f3n del rol";
    public static final String USER_NOT_FOUND = "No se ha encontrado la informaci\u00f3n del usuario";
    public static final String STATE_NOT_FOUND = "No se ha encontrado la informaci\u00f3n del estado de la tarea";
    public static final String TASK_NOT_FOUND = "No se ha encontrado la informaci\u00f3n de la tarea";
    public static final String LOGIN_NOT_FOUND_EMAIL = "No se ha encontrado el email del usuario";
    public static final String LOGIN_INCORRECT_PASSWORD = "La contraseña ingresada es incorrecta";
}
