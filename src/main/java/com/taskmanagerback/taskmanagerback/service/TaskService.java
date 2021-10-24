package com.taskmanagerback.taskmanagerback.service;

import com.taskmanagerback.taskmanagerback.model.StatusModel;
import com.taskmanagerback.taskmanagerback.model.TaskModel;
import com.taskmanagerback.taskmanagerback.model.TeamModel;
import com.taskmanagerback.taskmanagerback.model.UserModel;
import com.taskmanagerback.taskmanagerback.repository.TaskRepository;
import com.taskmanagerback.taskmanagerback.util.task.TaskParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskModel save(TaskParameter parameter) {
        TaskModel task = TaskModel.builder()
                .title(parameter.getTitle()).description(parameter.getDescription())
                .user(UserModel.builder().id(parameter.getUserId()).build())
                .team(TeamModel.builder().id(parameter.getTeamId()).build())
                .status(StatusModel.builder().id(parameter.getStatusId()).build())
                .build();
        return taskRepository.save(task);
    }

    public Optional<TaskModel> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }
}
