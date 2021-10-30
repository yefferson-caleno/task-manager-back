package com.yefferson.taskmanagerback.config;

public class ConstanstApiRest {

    public static final String HEALTH_MSG = "¡El servicio 'Task Maganer' se encuentra disponible!";

    // Request MSG.
    public static final String NOT_BLANK_TEAM_DESCRIPTION = "Debe agregar un nombre al equipo";
    public static final String NOT_NULL_TEAM_STATUS = "Debe agregar un estado al equipo";

    // Exception MSG.
    public static final String INVALID_PARAMS = "¡Par\u00e1metros de entrada invalidos!";
    public static final String STATUS_NOT_FOUND = "Estado de informaci\u00f3n no encontrado";
    public static final String TEAM_NOT_FOUND = "No se ha encontrado la informaci\u00f3n del equipo";
    public static final String DATA_NOT_FOUND = "La DB no se ha creado o los datos est\u00e1ticos no se insertaron " +
            "correctamente";
}
