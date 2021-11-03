package com.yefferson.taskmanagerback.repository;

import com.yefferson.taskmanagerback.model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateModel, Long> {
}
