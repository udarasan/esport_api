package com.example.esport_api.service.impl;

import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.UserDTO;
import com.example.esport_api.entity.Game;
import com.example.esport_api.entity.User;
import com.example.esport_api.repository.GameRepository;
import com.example.esport_api.service.GameService;
import com.example.esport_api.utill.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private AuditServiceImpl auditService;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public int saveGame(GameDTO gameDTO) {

            if (gameRepository.existsById(gameDTO.getGameID())) {
                auditService.saveAudit("saveGame","PASS:Save Game Now"+gameDTO.getGameName());
                return VarList.Not_Acceptable;
            } else {
                gameRepository.save(modelMapper.map(gameDTO, Game.class));
                auditService.saveAudit("saveGame","FAIL:Save Game Now"+gameDTO.getGameName());
                return VarList.Created;
            }


    }
    public List<GameDTO> getAllGames() {
        List<Game> all =gameRepository.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<GameDTO>>() {
        }.getType());
    }


}
