package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
import com.yefferson.taskmanagerback.model.UserModel;
import com.yefferson.taskmanagerback.util.exception.LoginNotFoundException;
import com.yefferson.taskmanagerback.util.login.LoginParameter;
import com.yefferson.taskmanagerback.util.login.LoginParameterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginService {
    @Autowired
    private UserService userService;

    public LoginParameterResponse login(LoginParameter parameter) throws LoginNotFoundException {
        UserModel user = userService.findByEmail(parameter.getEmail()).orElseThrow(LoginNotFoundException::new);
        if(DigestUtils.md5DigestAsHex(parameter.getPassword().getBytes()).equals(user.getPassword()) ) {
            return LoginParameterResponse.builder().name(user.getName()).email(user.getEmail()).role(user.getRole())
                    .build();
        }
        return null;
    }
}
