package com.taskmanagerback.taskmanagerback.service;

import com.taskmanagerback.taskmanagerback.model.StateModel;
import com.taskmanagerback.taskmanagerback.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public List<StateModel> findAll() {
        return stateRepository.findAll();
    }

    public Optional<StateModel> findById(Long id) {
        return stateRepository.findById(id);
    }
}