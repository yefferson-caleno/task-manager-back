package com.taskmanagerback.taskmanagerback.repository;

import com.taskmanagerback.taskmanagerback.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Long> {
}
