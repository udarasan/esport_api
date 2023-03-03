package com.example.esport_api.controller;

import com.example.esport_api.dto.EventRegistrationDTO;
import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.ResponseDTO;
import com.example.esport_api.service.EventRegService;
import com.example.esport_api.service.GameService;
import com.example.esport_api.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 15:52
 * @ProjectDetails esport_api
 */
@RestController
@RequestMapping("api/v1/eventRegistration")
public class EventRegistrationController {
    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private EventRegService eventRegService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDTO> addGame (@RequestBody EventRegistrationDTO eventRegistrationDTO) {
        try {
            int res = eventRegService.saveEventRegistration(eventRegistrationDTO);
            if (res==201) {
                responseDTO.setCode(VarList.Created);
                responseDTO.setMessage("success");
                responseDTO.setData(eventRegistrationDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
            } else if (res==406) {
                responseDTO.setCode(VarList.Not_Acceptable);
                responseDTO.setMessage("eventRegistrationDTO ID Already Use");
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
}
