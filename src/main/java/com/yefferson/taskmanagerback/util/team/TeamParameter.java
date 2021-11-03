package com.yefferson.taskmanagerback.util.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeamParameter {
    private String description;
    private Long statusId;
}
