package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.model.StatusModel;
import com.yefferson.taskmanagerback.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository repository;

    public Optional<StatusModel> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<StatusModel> findByDescription(String description) {
        return repository.findByDescription(description);
    }
}
