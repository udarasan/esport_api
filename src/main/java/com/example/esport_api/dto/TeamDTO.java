package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamDTO {
    private int teamId;
    private String teamName;
    private String description;
    private String country;

}
