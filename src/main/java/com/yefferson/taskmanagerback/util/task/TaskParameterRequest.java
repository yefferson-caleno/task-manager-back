package com.yefferson.taskmanagerback.util.task;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
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
    @NotBlank(message = ConstanstApiRest.NOT_BLANK_TASK_TITLE)
    private String title;

    private String description;

    private LocalDateTime taskInit;

    private LocalDateTime taskEnd;

    @NotNull(message = ConstanstApiRest.NOT_NULL_TASK_TEAM)
    private Long teamId;

    @NotNull(message = ConstanstApiRest.NOT_NULL_TASK_USER_ASSIGNED)
    private Long userAssignedId;

    @NotBlank(message = ConstanstApiRest.NOT_BLANK_TASK_USER_CREATED)
    private String userCreatedEmail;

    @NotNull(message = ConstanstApiRest.NOT_NULL_TASK_STATE)
    private Long stateId;

    @NotNull(message = ConstanstApiRest.NOT_NULL_TASK_STATUS)
    private Long statusId;
}
