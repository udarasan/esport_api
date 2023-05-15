package com.example.esport_api.controller;

import com.example.esport_api.dto.EventDTO;
import com.example.esport_api.dto.EventRegistrationDTO;
import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.ResponseDTO;
import com.example.esport_api.entity.User;
import com.example.esport_api.service.EventRegService;
import com.example.esport_api.service.GameService;
import com.example.esport_api.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDTO> addGame (@RequestBody EventRegistrationDTO eventRegistrationDTO, @RequestAttribute String username) {
        try {
            User s = new User();
            s.setUsername(username);
            eventRegistrationDTO.setUsername(s);
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
    @GetMapping("/getAllEventsReg")
    public ResponseEntity<ResponseDTO> getAllEvents() {
        try {

            //System.out.println(role);
            List<EventRegistrationDTO> eventDTOS = eventRegService.getAllEventRegDetails();
            responseDTO.setCode(VarList.Created);
            responseDTO.setMessage("Success");
            responseDTO.setData(eventDTOS);
            return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            responseDTO.setCode(VarList.Internal_Server_Error);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setData(e);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/getAllEventsRegByUserName")
    public ResponseEntity<ResponseDTO> getAllEventsRegByUserName(@RequestAttribute String username) {
        try {

            //System.out.println(role);
            List<EventRegistrationDTO> eventDTOS = eventRegService.getAllEventRegDetailsByUserName(username);
            responseDTO.setCode(VarList.Created);
            responseDTO.setMessage("Success");
            responseDTO.setData(eventDTOS);
            return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            responseDTO.setCode(VarList.Internal_Server_Error);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setData(e);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
