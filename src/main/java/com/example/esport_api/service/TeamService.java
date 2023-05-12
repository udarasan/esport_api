package com.example.esport_api.service;

import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.TeamDTO;

import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-03-04 16:33
 * @ProjectDetails esport_api
 */
public interface TeamService {
    int saveTeam(TeamDTO teamDTO);
    List<TeamDTO> getAllTeams();

    TeamDTO getLastTeamByID();
}
