package com.yefferson.taskmanagerback.controller;

import com.yefferson.taskmanagerback.model.UserModel;
import com.yefferson.taskmanagerback.service.UserService;
import com.yefferson.taskmanagerback.util.exception.RoleNotFoundException;
import com.yefferson.taskmanagerback.util.exception.StatusNotFoundException;
import com.yefferson.taskmanagerback.util.exception.TeamNotFoundException;
import com.yefferson.taskmanagerback.util.exception.UserNotFoundException;
import com.yefferson.taskmanagerback.util.response.Response;
import com.yefferson.taskmanagerback.util.user.UserParameter;
import com.yefferson.taskmanagerback.util.user.UserParameterRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    private ResponseEntity<Response<UserModel>> save(@Valid @RequestBody UserParameterRequest request)
            throws StatusNotFoundException, RoleNotFoundException, TeamNotFoundException {
        UserParameter parameter = mapper.map(request, UserParameter.class);
        return new ResponseEntity<>(Response.<UserModel>builder()
                .data(userService.save(parameter)).build(), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<Response<List<UserModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<UserModel>>builder()
                .data(userService.findAll()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response<UserModel>> findById(@PathVariable Long id) throws UserNotFoundException {
        UserModel user = userService.findById(id).orElseThrow(UserNotFoundException::new);
        return new ResponseEntity<>(Response.<UserModel>builder().data(user).build(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response<Boolean>> patch(@PathVariable Long id, @RequestBody UserParameter request)
            throws TeamNotFoundException, StatusNotFoundException, UserNotFoundException, RoleNotFoundException {

        return new ResponseEntity<>(Response.<Boolean>builder()
                .data(userService.update(id, request)).build(), HttpStatus.OK);
    }
}
