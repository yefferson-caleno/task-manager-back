package com.yefferson.taskmanagerback.controller;

import com.yefferson.taskmanagerback.model.RoleModel;
import com.yefferson.taskmanagerback.service.RoleService;
import com.yefferson.taskmanagerback.util.exception.RoleNotFoundException;
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
@RequestMapping(value = "api/role", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    private ResponseEntity<Response<List<RoleModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<RoleModel>>builder()
                .data(roleService.findAll()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response<RoleModel>> findById(@PathVariable Long id) throws RoleNotFoundException {
        RoleModel role = roleService.findById(id).orElseThrow(RoleNotFoundException::new);
        return new ResponseEntity<>(Response.<RoleModel>builder().data(role).build(), HttpStatus.OK);
    }
}
