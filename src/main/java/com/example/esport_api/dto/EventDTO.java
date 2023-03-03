package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 10:57
 * @ProjectDetails esport_api
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO {
    private int eventId;
    private GameDTO gameId;
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
