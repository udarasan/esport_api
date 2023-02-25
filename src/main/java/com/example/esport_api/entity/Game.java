package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author udarasan
 * @TimeStamp 2023-02-25 13:33
 * @ProjectDetails esport_api
 */
@Entity
@Table(name = "game")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameID;
    private String gameName;
    private String imageUrl;
    private String description;
}
