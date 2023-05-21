package com.example.esport_api.dto;

import com.example.esport_api.entity.Event;
import com.example.esport_api.entity.Game;
import com.example.esport_api.entity.Team;
import com.example.esport_api.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventRegistrationDTO {
    private int registrationId;
    private Event eventId;
    private User username;
    private String number;
    private String dob;
    private Team teamId;
}
