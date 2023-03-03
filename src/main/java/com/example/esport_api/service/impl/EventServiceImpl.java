package com.example.esport_api.service.impl;

import com.example.esport_api.dto.EventDTO;
import com.example.esport_api.dto.UserDTO;
import com.example.esport_api.entity.Event;
import com.example.esport_api.repository.EventRepository;
import com.example.esport_api.service.EventService;
import com.example.esport_api.utill.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 11:18
 * @ProjectDetails esport_api
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<EventDTO> getAllEventDetails() {

        List<Event> allEvents = eventRepository.findAll();
        return modelMapper.map(allEvents, new TypeToken<ArrayList<Event>>() {
        }.getType());
    }

    @Override
    public int saveEvent(EventDTO eventDTO) {

        if (!eventRepository.existsById(eventDTO.getEventId())) {
                 eventRepository.save(modelMapper.map(eventDTO, Event.class));
                 return VarList.Created;
        }else {
            return VarList.Bad_Request;
        }

    }

    @Override
    public int deleteEvent(int eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
            return VarList.Created;
        }else {
            return VarList.Bad_Request;
        }

    }

    @Override
    public int updateEvent(EventDTO eventDTO) {
        if (eventRepository.existsById(eventDTO.getEventId())) {
            eventRepository.save(modelMapper.map(eventDTO, Event.class));
            return VarList.Created;
        }else {
            return VarList.Bad_Request;
        }
    }
}
