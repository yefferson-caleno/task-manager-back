package com.taskmanagerback.taskmanagerback.util.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskParameter {
    private String title;
    private String description;
    private Long userId;
    private Long teamId;
    private Long statusId;
}
