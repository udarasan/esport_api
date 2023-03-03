package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 14:41
 * @ProjectDetails esport_api
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamDTO {
    private int teamId;
    private String teamName;
}
