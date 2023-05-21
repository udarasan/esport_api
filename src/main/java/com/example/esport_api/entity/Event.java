package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    @OneToOne
    private Game gameId;
    private String eventType;
    private String isPaid;
    private String payment;
    private String eventName;
    private Date startTime;
    private Date endTime;
    private String country;
    private String location;
    private String organizer;
    @Column(columnDefinition="TEXT")
    private String description;
    private String eventImage;

}
