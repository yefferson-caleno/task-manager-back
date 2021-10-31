package com.yefferson.taskmanagerback.util.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskParameter {
    private String title;
    private String description;
    private LocalDateTime taskInit;
    private LocalDateTime taskEnd;
    private Long teamId;
    private Long userAssignedId;
    private String userCreatedEmail;
    private Long stateId;
    private Long statusId;
}
