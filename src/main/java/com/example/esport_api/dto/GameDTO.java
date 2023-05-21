package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameDTO {
    private int gameID;
    private String gameName;
    private String imageUrl;
    private String description;
}
