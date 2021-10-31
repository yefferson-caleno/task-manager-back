package com.yefferson.taskmanagerback.util.user;

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
public class UserParameterRequest {

    @NotBlank(message = ConstanstApiRest.NOT_BLANK_USER_NAME)
    private String name;

    @NotBlank(message = ConstanstApiRest.NOT_BLANK_USER_EMAIL)
    private String email;

    @NotBlank(message = ConstanstApiRest.NOT_BLANK_USER_PASSWORD)
    private String password;

    @NotNull(message = ConstanstApiRest.NOT_NULL_USER_ROLE)
    private Long roleId;

    @NotNull(message = ConstanstApiRest.NOT_NULL_USER_TEAM)
    private Long teamId;

    @NotNull(message = ConstanstApiRest.NOT_NULL_USER_STATUS)
    private Long statusId;
}
