package com.example.esport_api.repository;

import com.example.esport_api.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author udarasan
 * @TimeStamp 2023-02-25 13:41
 * @ProjectDetails esport_api
 */
@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
}
