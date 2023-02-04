package com.example.esport_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author udarasan
 * @TimeStamp 2023-02-03 17:44
 * @ProjectDetails esport_api
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ResponseDTO {
    private int code;
    private String message;
    private Object data;
}
