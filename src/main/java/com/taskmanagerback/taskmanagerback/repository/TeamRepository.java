package com.taskmanagerback.taskmanagerback.repository;

import com.taskmanagerback.taskmanagerback.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamModel, Long> {
}
