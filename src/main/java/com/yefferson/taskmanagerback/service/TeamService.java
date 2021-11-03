package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.config.ConstanstApiRest;
import com.yefferson.taskmanagerback.model.StatusModel;
import com.yefferson.taskmanagerback.model.TeamModel;
import com.yefferson.taskmanagerback.repository.TeamRepository;
import com.yefferson.taskmanagerback.util.exception.StatusNotFoundException;
import com.yefferson.taskmanagerback.util.exception.TeamNotFoundException;
import com.yefferson.taskmanagerback.util.team.TeamParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;
    @Autowired
    private StatusService statusService;

    public TeamModel save(TeamParameter parameter) throws StatusNotFoundException {
        StatusModel status = statusService.findById(parameter.getStatusId()).orElseThrow(StatusNotFoundException::new);
        TeamModel team = TeamModel.builder().description(parameter.getDescription()).status(status).build();
        return repository.save(team);
    }

    public Optional<TeamModel> findById(Long id) {
        return repository.findById(id);
    }

    public List<TeamModel> findAll() {
        return repository.findAll();
    }

    public Boolean update(Long id, TeamParameter parameter) throws TeamNotFoundException, StatusNotFoundException {
        Boolean needUpdate = false;
        TeamModel team = this.findById(id).orElseThrow(TeamNotFoundException::new);

        if(StringUtils.hasLength(parameter.getDescription())) {
            team.setDescription(parameter.getDescription());
            needUpdate = true;
        }

        if(null != parameter.getStatusId()) {
            StatusModel status = statusService.findById(parameter.getStatusId())
                    .orElseThrow(StatusNotFoundException::new);
            team.setStatus(status);
            needUpdate = true;
        }

        if(needUpdate) {
            repository.save(team);
        }

        return needUpdate;
    }
}
