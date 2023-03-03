package com.example.esport_api.service;

import com.example.esport_api.dto.EventRegistrationDTO;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 15:54
 * @ProjectDetails esport_api
 */
public interface EventRegService {
    int saveEventRegistration(EventRegistrationDTO eventRegistrationDTO);
}
