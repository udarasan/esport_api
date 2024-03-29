package com.example.esport_api.service.impl;

import com.example.esport_api.dto.CountDTO;
import com.example.esport_api.dto.EventDTO;
import com.example.esport_api.dto.UserDTO;
import com.example.esport_api.entity.Event;
import com.example.esport_api.repository.EventRepository;
import com.example.esport_api.repository.GameRepository;
import com.example.esport_api.repository.TeamRepository;
import com.example.esport_api.service.EventService;
import com.example.esport_api.utill.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TeamRepository  teamRepository;
    @Autowired
    private GameRepository gameRepository;
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

    @Override
    public EventDTO getOneEvent(int eventId) {
        if (eventRepository.existsById(eventId)) {
            Event event=eventRepository.findById(eventId).orElse(null);
            EventDTO eventDTO = modelMapper.map(event,EventDTO.class);
            return eventDTO;
        }else {
            return null;
        }
    }

    @Override
    public CountDTO count() {
        CountDTO  countDTO=new CountDTO();
        countDTO.setEvent(eventRepository.count());
        countDTO.setTeam(teamRepository.count());
        countDTO.setPlayer(gameRepository.count());
        return countDTO;
    }
}
