package com.yefferson.taskmanagerback.util.login;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoginParameterRequest {

    @NotBlank(message = ConstanstApiRest.NOT_BLANK_LOGIN_EMAIL)
    private String email;

    @NotBlank(message = ConstanstApiRest.NOT_BLANK_LOGIN_PASSWORD)
    private String password;
}
