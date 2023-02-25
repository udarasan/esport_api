package com.example.esport_api.controller;

import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.ResponseDTO;
import com.example.esport_api.dto.UserDTO;
import com.example.esport_api.service.GameService;
import com.example.esport_api.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-02-25 13:36
 * @ProjectDetails esport_api
 */
@RestController
@RequestMapping("api/v1/game")
public class GameController {

    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private GameService gameService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDTO> addGame (@RequestBody GameDTO gameDTO) {
        try {
            int res = gameService.saveGame(gameDTO);
            if (res==201) {
                responseDTO.setCode(VarList.Created);
                responseDTO.setMessage("success");
                responseDTO.setData(gameDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
            } else if (res==406) {
                responseDTO.setCode(VarList.Not_Acceptable);
                responseDTO.setMessage("Game ID Already Use");
                responseDTO.setData(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_ACCEPTABLE);
            } else {
                responseDTO.setCode(VarList.Bad_Gateway);
                responseDTO.setMessage("Error");
                responseDTO.setData(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_GATEWAY);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.Internal_Server_Error);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setData(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<ResponseDTO> getAllUsers() {
        try{

            //System.out.println(role);
            List<GameDTO> allGames = gameService.getAllGames();
            responseDTO.setCode(VarList.Created);
            responseDTO.setMessage("Success");
            responseDTO.setData(allGames);
            return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
        }catch (Exception e){
            responseDTO.setCode(VarList.Internal_Server_Error);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setData(e);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
