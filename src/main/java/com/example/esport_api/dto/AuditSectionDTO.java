package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuditSectionDTO {
    private Integer aids;
    private String dates;
    private String functions;
    private String messages;
}