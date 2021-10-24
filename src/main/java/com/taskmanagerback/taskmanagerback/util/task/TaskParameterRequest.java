package com.taskmanagerback.taskmanagerback.util.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskParameterRequest {

    @NotBlank(message = "Debe ingresar el titulo de la tarea")
    private String title;

    private String description;

    @NotBlank(message = "Debe asignar un usuario a la tarea")
    private Long userId;

    @NotBlank(message = "Debe agregar un equipo a la tarea")
    private Long teamId;

    @NotBlank(message = "Debe activar/desactivar la tarea")
    private Long statusId;
}
