package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-02-25 13:36
 * @ProjectDetails esport_api
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameDTO {
    private int gameID;
    private String gameName;
    private String imageUrl;
    private String description;
}
