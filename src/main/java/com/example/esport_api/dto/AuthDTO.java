package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-02-04 11:05
 * @ProjectDetails esport_api
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthDTO {
    private String username;
    private String token;
}