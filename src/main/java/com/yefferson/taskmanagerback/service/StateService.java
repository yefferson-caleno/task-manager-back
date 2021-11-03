package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.model.StateModel;
import com.yefferson.taskmanagerback.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public Optional<StateModel> findById(Long id) {
        return stateRepository.findById(id);
    }

    public List<StateModel> findAll() {
        return stateRepository.findAll();
    }
}
