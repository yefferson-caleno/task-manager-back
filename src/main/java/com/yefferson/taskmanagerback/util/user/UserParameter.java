package com.yefferson.taskmanagerback.util.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserParameter {

    private String name;
    private String email;
    private String password;
    private Long roleId;
    private Long teamId;
    private Long statusId;

}
