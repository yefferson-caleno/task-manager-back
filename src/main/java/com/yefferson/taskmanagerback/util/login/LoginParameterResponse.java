package com.yefferson.taskmanagerback.util.login;

import com.yefferson.taskmanagerback.model.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoginParameterResponse {
    private String name;
    private String email;
    private RoleModel role;
}
