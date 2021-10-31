package com.yefferson.taskmanagerback.controller;

import com.yefferson.taskmanagerback.model.StatusModel;
import com.yefferson.taskmanagerback.service.StatusService;
import com.yefferson.taskmanagerback.util.exception.StatusNotFoundException;
import com.yefferson.taskmanagerback.util.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/status", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    private ResponseEntity<Response<List<StatusModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<StatusModel>>builder()
                .data(statusService.findAll()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response<StatusModel>> findById(@PathVariable Long id) throws StatusNotFoundException {
        StatusModel status = statusService.findById(id).orElseThrow(StatusNotFoundException::new);
        return new ResponseEntity<>(Response.<StatusModel>builder().data(status).build(), HttpStatus.OK);
    }
}
