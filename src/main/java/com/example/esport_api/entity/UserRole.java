package com.example.esport_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-02-04 09:39
 * @ProjectDetails esport_api
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "userrole")
public class UserRole {
    @Id
    private int userRoleCode;
    private String userRoleDesc;
}