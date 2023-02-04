package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-02-04 09:45
 * @ProjectDetails esport_api
 */
@Entity
@Table(name = "audit_section")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuditSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aids;
    private String dates;
    private String functions;
    private String messages;
}