package com.taskmanagerback.taskmanagerback.util.task;

import com.taskmanagerback.taskmanagerback.model.StatusModel;
import com.taskmanagerback.taskmanagerback.model.TeamModel;
import com.taskmanagerback.taskmanagerback.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskParameterRequest {

    @NotNull(message = "Debe ingresar el titulo de la tarea")
    private String title;

    private String description;

    private Long userId;

    private Long teamId;

    private Long statusId;
}
