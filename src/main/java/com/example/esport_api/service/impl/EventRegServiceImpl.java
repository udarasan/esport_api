package com.example.esport_api.service.impl;

import com.example.esport_api.dto.EventRegistrationDTO;
import com.example.esport_api.entity.Event;
import com.example.esport_api.entity.EventRegistration;
import com.example.esport_api.repository.EventRegistrationRepository;
import com.example.esport_api.service.EventRegService;
import com.example.esport_api.utill.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
