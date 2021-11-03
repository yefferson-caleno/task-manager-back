package com.yefferson.taskmanagerback.controller;

import com.yefferson.taskmanagerback.model.TaskModel;
import com.yefferson.taskmanagerback.service.TaskService;
import com.yefferson.taskmanagerback.util.exception.*;
import com.yefferson.taskmanagerback.util.response.Response;
import com.yefferson.taskmanagerback.util.task.TaskParameter;
import com.yefferson.taskmanagerback.util.task.TaskParameterRequest;
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
@RequestMapping(value = "api/task", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    private ResponseEntity<Response<TaskModel>> save(@Valid @RequestBody TaskParameterRequest request)
            throws StatusNotFoundException, TeamNotFoundException, UserNotFoundException, StateNotFoundException,
            LoginNotFoundException {
        TaskParameter parameter = mapper.map(request, TaskParameter.class);
        return new ResponseEntity<>(Response.<TaskModel>builder()
                .data(taskService.save(parameter)).build(), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<Response<List<TaskModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<TaskModel>>builder()
                .data(taskService.findAll()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response<TaskModel>> findById(@PathVariable Long id) throws TaskNotFoundException {
        TaskModel task = taskService.findById(id).orElseThrow(TaskNotFoundException::new);
        return new ResponseEntity<>(Response.<TaskModel>builder().data(task).build(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response<Boolean>> patch(@PathVariable Long id, @RequestBody TaskParameter request)
            throws TeamNotFoundException, StatusNotFoundException, UserNotFoundException, TaskNotFoundException,
            StateNotFoundException {

        return new ResponseEntity<>(Response.<Boolean>builder()
                .data(taskService.update(id, request)).build(), HttpStatus.OK);
    }
}
