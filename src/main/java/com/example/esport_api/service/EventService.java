package com.example.esport_api.service;

import com.example.esport_api.dto.CountDTO;
import com.example.esport_api.dto.EventDTO;

import java.util.List;


public interface EventService {
     List<EventDTO> getAllEventDetails();
     int saveEvent(EventDTO eventDTO);
     int deleteEvent(int eventId);
     int updateEvent(EventDTO eventDTO);

     EventDTO getOneEvent(int eventId);

    CountDTO count();
}
