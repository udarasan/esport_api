package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {
    private int eventId;
    private String gameId;
    private String eventType;
    private String isPaid;
    private String payment;
    private String eventName;
    private Date startTime;
    private Date endTime;
    private String country;
    private String location;
    private String organizer;
    private String description;
    private String eventImage;
}
