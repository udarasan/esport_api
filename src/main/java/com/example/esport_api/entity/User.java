package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author udarasan
 * @TimeStamp 2023-02-04 09:38
 * @ProjectDetails esport_api
 */
@Entity
@Table(name = "systemuser")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    @Id
    private String username;
    private String password;
    private String status;
    private String phoneNo;
    private String idPhoto;
    private String email;
    private String name;

    @OneToOne
    @JoinColumn(name = "roleCode", referencedColumnName = "UserRoleCode")
    private UserRole roleCode;



}