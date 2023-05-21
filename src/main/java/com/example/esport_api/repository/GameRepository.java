package com.example.esport_api.repository;

import com.example.esport_api.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
}
