package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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