package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 10:57
 * @ProjectDetails esport_api
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    @OneToOne(cascade = CascadeType.ALL)
    private Game gameId;
    private String eventType;
    private String eventName;
    private Date startTime;
    private Date endTime;
    private String country;
    private String location;
    private String organizer;
    private String description;
    private String eventImage;

}