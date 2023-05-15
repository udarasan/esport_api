package com.example.esport_api.service.impl;

import com.example.esport_api.dto.EventRegistrationDTO;
import com.example.esport_api.entity.EventRegistration;
import com.example.esport_api.entity.User;
import com.example.esport_api.repository.EventRegistrationRepository;
import com.example.esport_api.service.EventRegService;
import com.example.esport_api.utill.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 15:55
 * @ProjectDetails esport_api
 */
@Service
public class EventRegServiceImpl implements EventRegService {
    @Autowired
    private EventRegistrationRepository eventRegistrationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveEventRegistration(EventRegistrationDTO eventRegistrationDTO) {
        if (!eventRegistrationRepository.existsById(eventRegistrationDTO.getRegistrationId())) {
            eventRegistrationRepository.save(modelMapper.map(eventRegistrationDTO, EventRegistration.class));
            return VarList.Created;
        }else {
            return VarList.Bad_Request;
        }
    }

    @Override
    public List<EventRegistrationDTO> getAllEventRegDetails() {

        List<EventRegistration> allEvents = eventRegistrationRepository.findAll();
        return modelMapper.map(allEvents, new TypeToken<ArrayList<EventRegistration>>() {
        }.getType());
    }

    @Override
    public List<EventRegistrationDTO> getAllEventRegDetailsByUserName(String username) {
        User news=new User();
        news.setUsername(username);
        List<EventRegistration> allEvents = eventRegistrationRepository.findAllByUsername(news);
        return modelMapper.map(allEvents, new TypeToken<ArrayList<EventRegistration>>() {
        }.getType());
    }
}
