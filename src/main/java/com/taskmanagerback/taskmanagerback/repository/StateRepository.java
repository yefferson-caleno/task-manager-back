package com.taskmanagerback.taskmanagerback.repository;

import com.taskmanagerback.taskmanagerback.model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateModel, Long> {
}
