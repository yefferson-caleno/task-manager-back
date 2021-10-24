package com.taskmanagerback.taskmanagerback.service;
import com.taskmanagerback.taskmanagerback.model.StatusModel;
import com.taskmanagerback.taskmanagerback.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<StatusModel> findAll() {
        return statusRepository.findAll();
    }

    public Optional<StatusModel> findById(Long id) {
        return statusRepository.findById(id);
    }
}