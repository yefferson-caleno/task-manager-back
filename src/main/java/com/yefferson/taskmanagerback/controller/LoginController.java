package com.yefferson.taskmanagerback.controller;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
import com.yefferson.taskmanagerback.service.LoginService;
import com.yefferson.taskmanagerback.util.exception.LoginNotFoundException;
import com.yefferson.taskmanagerback.util.login.LoginParameter;
import com.yefferson.taskmanagerback.util.login.LoginParameterRequest;
import com.yefferson.taskmanagerback.util.login.LoginParameterResponse;
import com.yefferson.taskmanagerback.util.response.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    private ResponseEntity<Response<LoginParameterResponse>> login(@Valid @RequestBody LoginParameterRequest request)
            throws LoginNotFoundException {
        LoginParameter parameter = mapper.map(request, LoginParameter.class);
        LoginParameterResponse response = loginService.login(parameter);
        if (Objects.isNull(response)) {
            return new ResponseEntity<>(Response.<LoginParameterResponse>builder()
                    .message(ConstanstApiRest.LOGIN_INCORRECT_PASSWORD)
                    .status(HttpStatus.UNAUTHORIZED.value()).build(), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(Response.<LoginParameterResponse>builder()
                .data(response).build(), HttpStatus.OK);
    }
}
