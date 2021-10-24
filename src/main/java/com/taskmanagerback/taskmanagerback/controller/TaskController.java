package com.taskmanagerback.taskmanagerback.controller;

import com.taskmanagerback.taskmanagerback.model.TaskModel;
import com.taskmanagerback.taskmanagerback.service.TaskService;
import com.taskmanagerback.taskmanagerback.util.response.Response;
import com.taskmanagerback.taskmanagerback.util.task.TaskParameter;
import com.taskmanagerback.taskmanagerback.util.task.TaskParameterRequest;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    private ObjectMapper mapper;

    @PostMapping
    private ResponseEntity<Response<TaskModel>> save(
            @Valid @RequestBody TaskParameterRequest request) {
        TaskParameter parameter = mapper.mapBuilder(request,
                TaskParameter.TaskParameterBuilder.class).build();
        return new ResponseEntity<>(Response.<TaskModel>builder()
                .data(taskService.save(parameter)).build(), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<Response<List<TaskModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<TaskModel>>builder()
                .data(taskService.findAll()).build(), HttpStatus.OK);
    }
}
