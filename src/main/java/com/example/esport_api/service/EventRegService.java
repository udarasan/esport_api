package com.example.esport_api.service;

import com.example.esport_api.dto.EventRegistrationDTO;

import java.util.List;


public interface EventRegService {
    int saveEventRegistration(EventRegistrationDTO eventRegistrationDTO);

    List<EventRegistrationDTO> getAllEventRegDetails();

    List<EventRegistrationDTO> getAllEventRegDetailsByUserName(String username);
}
