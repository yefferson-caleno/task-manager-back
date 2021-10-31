package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.model.RoleModel;
import com.yefferson.taskmanagerback.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Optional<RoleModel> findById(Long id) {
        return roleRepository.findById(id);
    }

}
