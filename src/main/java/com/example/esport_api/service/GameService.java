package com.example.esport_api.service;

import com.example.esport_api.dto.GameDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GameService {
     int saveGame(GameDTO gameDTO);
     List<GameDTO> getAllGames();
}
