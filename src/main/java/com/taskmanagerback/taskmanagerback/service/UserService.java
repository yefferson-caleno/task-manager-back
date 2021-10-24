package com.taskmanagerback.taskmanagerback.service;

import com.taskmanagerback.taskmanagerback.model.TeamModel;
import com.taskmanagerback.taskmanagerback.model.UserModel;
import com.taskmanagerback.taskmanagerback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }
}
