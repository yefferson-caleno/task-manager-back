package com.taskmanagerback.taskmanagerback.service;

import com.taskmanagerback.taskmanagerback.model.TeamModel;
import com.taskmanagerback.taskmanagerback.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<TeamModel> findAll() {
        return teamRepository.findAll();
    }

    public Optional<TeamModel> findById(Long id) {
        return teamRepository.findById(id);
    }
}
