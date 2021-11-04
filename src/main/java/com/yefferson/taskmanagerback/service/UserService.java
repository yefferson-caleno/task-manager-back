package com.yefferson.taskmanagerback.service;

import com.yefferson.taskmanagerback.model.RoleModel;
import com.yefferson.taskmanagerback.model.StatusModel;
import com.yefferson.taskmanagerback.model.TeamModel;
import com.yefferson.taskmanagerback.model.UserModel;
import com.yefferson.taskmanagerback.repository.UserRepository;
import com.yefferson.taskmanagerback.util.exception.RoleNotFoundException;
import com.yefferson.taskmanagerback.util.exception.StatusNotFoundException;
import com.yefferson.taskmanagerback.util.exception.TeamNotFoundException;
import com.yefferson.taskmanagerback.util.exception.UserNotFoundException;
import com.yefferson.taskmanagerback.util.user.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private RoleService roleService;

    public UserModel save(UserParameter parameter)
            throws StatusNotFoundException, TeamNotFoundException, RoleNotFoundException {
        StatusModel status = statusService.findById(parameter.getStatusId()).orElseThrow(StatusNotFoundException::new);
        TeamModel team = teamService.findById(parameter.getTeamId()).orElseThrow(TeamNotFoundException::new);
        RoleModel role = roleService.findById(parameter.getRoleId()).orElseThrow(RoleNotFoundException::new);
        String md5Password = DigestUtils.md5DigestAsHex(parameter.getPassword().getBytes());
        UserModel user = UserModel.builder().name(parameter.getName()).email(parameter.getEmail())
                .password(md5Password).status(status).team(team).role(role)
                .created(LocalDateTime.now().minusHours(5L)).updated(LocalDateTime.now().minusHours(5L)).build();
        return userRepository.save(user);
    }

    public Optional<UserModel> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public Boolean update(Long id, UserParameter parameter)
            throws TeamNotFoundException, StatusNotFoundException, UserNotFoundException, RoleNotFoundException {
        Boolean needUpdate = false;
        UserModel user = this.findById(id).orElseThrow(UserNotFoundException::new);

        if(StringUtils.hasLength(parameter.getName())) {
            user.setName(parameter.getName());
            needUpdate = true;
        }

        if(StringUtils.hasLength(parameter.getEmail())) {
            user.setEmail(parameter.getEmail());
            needUpdate = true;
        }

        if(StringUtils.hasLength(parameter.getPassword())) {
            String md5Password = DigestUtils.md5DigestAsHex(parameter.getPassword().getBytes());
            user.setPassword(md5Password);
            needUpdate = true;
        }

        if(null != parameter.getStatusId()) {
            StatusModel status = statusService.findById(parameter.getStatusId())
                    .orElseThrow(StatusNotFoundException::new);
            user.setStatus(status);
            needUpdate = true;
        }

        if(null != parameter.getTeamId()) {
            TeamModel team = teamService.findById(parameter.getTeamId())
                    .orElseThrow(TeamNotFoundException::new);
            user.setTeam(team);
            needUpdate = true;
        }

        if(null != parameter.getRoleId()) {
            RoleModel role = roleService.findById(parameter.getRoleId())
                    .orElseThrow(RoleNotFoundException::new);
            user.setRole(role);
            needUpdate = true;
        }

        if(needUpdate) {
            user.setUpdated(LocalDateTime.now().minusHours(5L));
            userRepository.save(user);
        }

        return needUpdate;
    }
}
