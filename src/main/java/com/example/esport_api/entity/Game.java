package com.example.esport_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @Column(columnDefinition="TEXT")
    private String description;


}
