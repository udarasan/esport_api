package com.example.esport_api.service.impl;

import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.TeamDTO;
import com.example.esport_api.entity.Game;
import com.example.esport_api.entity.Team;
import com.example.esport_api.repository.GameRepository;
import com.example.esport_api.repository.TeamRepository;
import com.example.esport_api.service.TeamService;
import com.example.esport_api.utill.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-03-04 16:33
 * @ProjectDetails esport_api
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private AuditServiceImpl auditService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveTeam(TeamDTO teamDTO) {
        if (teamRepository.existsById(teamDTO.getTeamId())) {
            auditService.saveAudit("saveTeam","PASS:Save Team Now"+teamDTO.getTeamName());
            return VarList.Not_Acceptable;
        } else {
            teamRepository.save(modelMapper.map(teamDTO, Team.class));
            auditService.saveAudit("saveGame","FAIL:Save Game Now"+teamDTO.getTeamId());
            return VarList.Created;
        }
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> all =teamRepository.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<TeamDTO>>() {
        }.getType());

    }

    @Override
    public TeamDTO getLastTeamByID() {
        Team lastTeam=teamRepository.getLastTeam();
        return modelMapper.map(lastTeam,TeamDTO.class);
    }
}
