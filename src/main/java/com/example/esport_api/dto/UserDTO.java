package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-02-03 17:47
 * @ProjectDetails esport_api
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String username;
    private String password;
    private String status;
    private String phoneNo;
    private String idPhoto;
    private String email;
    private String name;
    private UserRoleDTO roleCode;
}
