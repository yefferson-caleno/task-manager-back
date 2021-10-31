package com.yefferson.taskmanagerback.controller;

import com.yefferson.taskmanagerback.model.StateModel;
import com.yefferson.taskmanagerback.service.StateService;
import com.yefferson.taskmanagerback.util.exception.StateNotFoundException;
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
@RequestMapping(value = "api/state", produces = MediaType.APPLICATION_JSON_VALUE)
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping
    private ResponseEntity<Response<List<StateModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<StateModel>>builder()
                .data(stateService.findAll()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response<StateModel>> findById(@PathVariable Long id) throws StateNotFoundException {
        StateModel state = stateService.findById(id).orElseThrow(StateNotFoundException::new);
        return new ResponseEntity<>(Response.<StateModel>builder().data(state).build(), HttpStatus.OK);
    }
}
