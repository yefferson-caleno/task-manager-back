package com.yefferson.taskmanagerback.controller;

import com.yefferson.taskmanagerback.model.TeamModel;
import com.yefferson.taskmanagerback.service.TeamService;
import com.yefferson.taskmanagerback.util.exception.StatusNotFoundException;
import com.yefferson.taskmanagerback.util.exception.TeamNotFoundException;
import com.yefferson.taskmanagerback.util.response.Response;
import com.yefferson.taskmanagerback.util.team.TeamParameter;
import com.yefferson.taskmanagerback.util.team.TeamParameterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/team", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping
    private ResponseEntity<Response<TeamModel>> save(@Valid @RequestBody TeamParameterRequest request)
            throws StatusNotFoundException {
        TeamParameter parameter = mapper.map(request, TeamParameter.class);
        return new ResponseEntity<>(Response.<TeamModel>builder()
                .data(teamService.save(parameter)).build(), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<Response<List<TeamModel>>> findAll() {
        return new ResponseEntity<>(Response.<List<TeamModel>>builder()
                .data(teamService.findAll()).build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Response<TeamModel>> findById(@PathVariable Long id) throws TeamNotFoundException {
        TeamModel team = teamService.findById(id).orElseThrow(TeamNotFoundException::new);
        return new ResponseEntity<>(Response.<TeamModel>builder().data(team).build(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Response<Boolean>> patch(@PathVariable Long id, @RequestBody TeamParameter request)
            throws TeamNotFoundException, StatusNotFoundException {

        return new ResponseEntity<>(Response.<Boolean>builder()
                .data(teamService.update(id, request)).build(), HttpStatus.OK);
    }
}
