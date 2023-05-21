package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "eventregistration")
public class EventRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationId;
    @OneToOne
    @JoinColumn(name = "eventId", referencedColumnName = "eventId")
    private Event eventId;
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;
    private String number;
    private String dob;
    @OneToOne
    @JoinColumn(name = "teamId", referencedColumnName = "teamId")
    private Team teamId;

}
