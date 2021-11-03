package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
import com.yefferson.taskmanagerback.model.*;
import com.yefferson.taskmanagerback.repository.TaskRepository;
import com.yefferson.taskmanagerback.util.exception.*;
import com.yefferson.taskmanagerback.util.task.TaskParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private StateService stateService;
    @Autowired
    private UserService userService;

    public TaskModel save(TaskParameter parameter)
            throws StatusNotFoundException, TeamNotFoundException, UserNotFoundException, StateNotFoundException,
            LoginNotFoundException {
        StatusModel status = statusService.findById(parameter.getStatusId()).orElseThrow(StatusNotFoundException::new);
        TeamModel team = teamService.findById(parameter.getTeamId()).orElseThrow(TeamNotFoundException::new);
        UserModel userAssigned = userService.findById(parameter.getUserAssignedId())
                .orElseThrow(UserNotFoundException::new);
        UserModel userCreated = userService.findByEmail(parameter.getUserCreatedEmail())
                .orElseThrow(LoginNotFoundException::new);
        StateModel state = stateService.findById(parameter.getStateId()).orElseThrow(StateNotFoundException::new);
        TaskModel task = TaskModel.builder().title(parameter.getTitle()).description(parameter.getDescription())
                .taskInit(parameter.getTaskInit()).taskEnd(parameter.getTaskEnd()).team(team).status(status)
                .userAssigned(userAssigned).userCreated(userCreated).state(state).build();
        if(state.getDescription().equals(ConstanstApiRest.STATE_ACTIVE)) task.setTaskInit(LocalDateTime.now());
        if(state.getDescription().equals(ConstanstApiRest.STATE_CLOSED)) task.setTaskEnd(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Optional<TaskModel> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    public Boolean update(Long id, TaskParameter parameter)
            throws TeamNotFoundException, StatusNotFoundException, UserNotFoundException, TaskNotFoundException,
            StateNotFoundException {
        Boolean needUpdate = false;
        TaskModel task = this.findById(id).orElseThrow(TaskNotFoundException::new);

        if(StringUtils.hasLength(parameter.getTitle())) {
            task.setTitle(parameter.getTitle());
            needUpdate = true;
        }

        if(StringUtils.hasLength(parameter.getDescription())) {
            task.setDescription(parameter.getDescription());
            needUpdate = true;
        }

        if(null != parameter.getUserAssignedId()) {
            UserModel user = userService.findById(parameter.getUserAssignedId())
                    .orElseThrow(UserNotFoundException::new);
            task.setUserAssigned(user);
        }

        if(StringUtils.hasLength(parameter.getUserCreatedEmail())) {
            UserModel user = userService.findByEmail(parameter.getUserCreatedEmail())
                    .orElseThrow(UserNotFoundException::new);
            task.setUserCreated(user);
        }

        if(null != parameter.getTaskInit()) {
            task.setTaskInit(parameter.getTaskInit());
            needUpdate = true;
        }

        if(null != parameter.getTaskEnd()) {
            task.setTaskEnd(parameter.getTaskEnd());
            needUpdate = true;
        }

        if(null != parameter.getStatusId()) {
            StatusModel status = statusService.findById(parameter.getStatusId())
                    .orElseThrow(StatusNotFoundException::new);
            task.setStatus(status);
            needUpdate = true;
        }

        if(null != parameter.getTeamId()) {
            TeamModel team = teamService.findById(parameter.getTeamId())
                    .orElseThrow(TeamNotFoundException::new);
            task.setTeam(team);
            needUpdate = true;
        }

        if(null != parameter.getStateId()) {
            StateModel state = stateService.findById(parameter.getStateId())
                    .orElseThrow(StateNotFoundException::new);
            task.setState(state);
            if(state.getDescription().equals(ConstanstApiRest.STATE_ACTIVE)) task.setTaskInit(LocalDateTime.now());
            if(state.getDescription().equals(ConstanstApiRest.STATE_CLOSED)) task.setTaskEnd(LocalDateTime.now());
            needUpdate = true;
        }

        if(needUpdate) {
            task.setUpdated(LocalDateTime.now());
            taskRepository.save(task);
        }

        return needUpdate;
    }
}
