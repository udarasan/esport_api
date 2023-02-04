package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-02-03 17:48
 * @ProjectDetails esport_api
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleDTO {
    private int userRoleCode;
    private String userRoleDesc;
}
