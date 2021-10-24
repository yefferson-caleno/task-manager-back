package com.taskmanagerback.taskmanagerback.service;

import com.taskmanagerback.taskmanagerback.model.StatusModel;
import com.taskmanagerback.taskmanagerback.model.TaskModel;
import com.taskmanagerback.taskmanagerback.model.TeamModel;
import com.taskmanagerback.taskmanagerback.model.UserModel;
import com.taskmanagerback.taskmanagerback.repository.TaskRepository;
import com.taskmanagerback.taskmanagerback.util.exception.StatusNotFoundException;
import com.taskmanagerback.taskmanagerback.util.exception.TeamNotFoundException;
import com.taskmanagerback.taskmanagerback.util.exception.UserNotFoundException;
import com.taskmanagerback.taskmanagerback.util.task.TaskParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private StatusService statusService;

    public TaskModel save(TaskParameter parameter)
            throws UserNotFoundException, TeamNotFoundException, StatusNotFoundException {
        UserModel user = userService.findById(parameter.getUserId()).orElseThrow(UserNotFoundException::new);
        TeamModel team = teamService.findById(parameter.getTeamId()).orElseThrow(TeamNotFoundException::new);
        StatusModel status = statusService.findById(parameter.getStatusId()).orElseThrow(StatusNotFoundException::new);
        TaskModel task = TaskModel.builder().title(parameter.getTitle()).description(parameter.getDescription())
                .user(user).team(team).status(status).build();
        return taskRepository.save(task);
    }

    public Optional<TaskModel> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }
}
