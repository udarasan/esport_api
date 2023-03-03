package com.example.esport_api.service;

import com.example.esport_api.dto.EventDTO;

import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 11:18
 * @ProjectDetails esport_api
 */
public interface EventService {
     List<EventDTO> getAllEventDetails();
     int saveEvent(EventDTO eventDTO);
     int deleteEvent(int eventId);
     int updateEvent(EventDTO eventDTO);
}
