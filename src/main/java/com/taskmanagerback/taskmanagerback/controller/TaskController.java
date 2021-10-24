package com.taskmanagerback.taskmanagerback.controller;

import com.taskmanagerback.taskmanagerback.model.TaskModel;
import com.taskmanagerback.taskmanagerback.service.TaskService;
import com.taskmanagerback.taskmanagerback.util.exception.StatusNotFoundException;
import com.taskmanagerback.taskmanagerback.util.exception.TeamNotFoundException;
import com.taskmanagerback.taskmanagerback.util.exception.UserNotFoundException;
import com.taskmanagerback.taskmanagerback.util.response.Response;
import com.taskmanagerback.taskmanagerback.util.task.TaskParameter;
import com.taskmanagerback.taskmanagerback.util.task.TaskParameterRequest;
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
@RequestMapping(value = "/api/task", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    private ResponseEntity<Response<TaskModel>> save(
            @Valid @RequestBody TaskParameterRequest request)
            throws UserNotFoundException, StatusNotFoundException, TeamNotFoundException {
        TaskParameter parameter = mapper.map(request, TaskParameter.class);
        String tt = parameter.getTitle();
        return new ResponseEntity<>(Response.<TaskModel>builder()
                .data(taskService.save(parameter)).build(), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<Response<List<TaskModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<TaskModel>>builder()
                .data(taskService.findAll()).build(), HttpStatus.OK);
    }
}
