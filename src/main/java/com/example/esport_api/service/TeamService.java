package com.example.esport_api.service;

import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.TeamDTO;

import java.util.List;


public interface TeamService {
    int saveTeam(TeamDTO teamDTO);
    List<TeamDTO> getAllTeams();

    TeamDTO getLastTeamByID();
}
