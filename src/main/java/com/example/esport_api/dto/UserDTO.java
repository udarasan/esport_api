package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private String roleCode;
    private String teamId;
}
