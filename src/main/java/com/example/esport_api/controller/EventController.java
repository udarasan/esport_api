package com.example.esport_api.controller;

import com.example.esport_api.dto.EventDTO;
import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.ResponseDTO;
import com.example.esport_api.service.EventService;
import com.example.esport_api.service.GameService;
import com.example.esport_api.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 10:47
 * @ProjectDetails esport_api
 */
@RestController
@RequestMapping("api/v1/event")
public class EventController {
    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private EventService eventService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDTO> addEvent(@RequestBody EventDTO eventDTO) {
        try {
            int res = eventService.saveEvent(eventDTO);
            if (res == 201) {
                responseDTO.setCode(VarList.Created);
                responseDTO.setMessage("success");
                responseDTO.setData(eventDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
            } else if (res == 406) {
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

    @GetMapping("/getAllEvents")
    public ResponseEntity<ResponseDTO> getAllEvents() {
        try {

            //System.out.println(role);
            List<EventDTO> eventDTOS = eventService.getAllEventDetails();
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

    @DeleteMapping(value = "/deleteEvent")
    public ResponseEntity<ResponseDTO> deleteEvent(@RequestParam int eventId) {
        try {
            int res = eventService.deleteEvent(eventId);
            if (res == 201) {
                responseDTO.setCode(VarList.Created);
                responseDTO.setMessage("success");
                responseDTO.setData(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
            } else if (res == 406) {
                responseDTO.setCode(VarList.Not_Acceptable);
                responseDTO.setMessage("Event ID Already Use");
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