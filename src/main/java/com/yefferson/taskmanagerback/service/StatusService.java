package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.model.StateModel;
import com.yefferson.taskmanagerback.model.StatusModel;
import com.yefferson.taskmanagerback.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Optional<StatusModel> findById(Long id) {
        return statusRepository.findById(id);
    }

    public Optional<StatusModel> findByDescription(String description) {
        return statusRepository.findByDescription(description);
    }

    public List<StatusModel> findAll() {
        return statusRepository.findAll();
    }
}
