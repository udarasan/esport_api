package com.example.esport_api.controller;

import com.example.esport_api.dto.CountDTO;
import com.example.esport_api.dto.EventDTO;
import com.example.esport_api.dto.GameDTO;
import com.example.esport_api.dto.ResponseDTO;
import com.example.esport_api.service.EventService;
import com.example.esport_api.service.GameService;
import com.example.esport_api.utill.FileUploadUtil;
import com.example.esport_api.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    @PostMapping("/upload")
    public void saveImage(@RequestParam("files") MultipartFile[] files){
        String uploadDir="eventImages";
        Arrays.asList(files).stream().forEach(file->{
            String fileName= StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            System.out.println(fileName);
            try {
                FileUploadUtil.saveFile(uploadDir,fileName,file);
            }catch (IOException ioException){

            }
        });

    }

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
    @GetMapping("/count")
    public ResponseEntity<ResponseDTO> count() {
        try {

            //System.out.println(role);
            CountDTO eventDTOS = eventService.count();
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
    @GetMapping("/getOneEvent")
    public ResponseEntity<ResponseDTO> getOneEvent(@RequestParam int eventId) {
        try {

            //System.out.println(role);
            EventDTO eventDTOS = eventService.getOneEvent(eventId);
            if(eventDTOS==null){
                responseDTO.setCode(VarList.Bad_Gateway);
                responseDTO.setMessage("No Data");
                responseDTO.setData(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_GATEWAY);

            }
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
    public ResponseEntity<ResponseDTO> deleteEvent(@PathVariable int eventId) {
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