package com.example.esport_api.controller;

import com.example.esport_api.dto.AuditSectionDTO;
import com.example.esport_api.dto.EventDTO;
import com.example.esport_api.dto.ResponseDTO;
import com.example.esport_api.service.AuditService;
import com.example.esport_api.service.EventService;
import com.example.esport_api.service.impl.AuditServiceImpl;
import com.example.esport_api.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-05-15 23:47
 * @ProjectDetails esport_api
 */
@RestController
@RequestMapping("api/v1/audit")
public class AuditController {
    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private AuditServiceImpl auditService;
    @GetMapping("/getAllAudits")
    public ResponseEntity<ResponseDTO> getAllEvents() {
        try {

            //System.out.println(role);
            List<AuditSectionDTO> eventDTOS = auditService.getAllAudits();
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
