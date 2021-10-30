package com.yefferson.taskmanagerback.util.team;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeamParameterRequest {

    @NotBlank(message = ConstanstApiRest.NOT_BLANK_TEAM_DESCRIPTION)
    private String description;

    @NotNull(message = ConstanstApiRest.NOT_NULL_TEAM_STATUS)
    private Long statusId;
}
