package com.taskmanagerback.taskmanagerback.repository;

import com.taskmanagerback.taskmanagerback.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
