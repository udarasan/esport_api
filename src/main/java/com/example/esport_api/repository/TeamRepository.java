package com.example.esport_api.repository;

import com.example.esport_api.dto.TeamDTO;
import com.example.esport_api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    @Query(value = "SELECT * FROM team ORDER BY team_id DESC LIMIT 1",nativeQuery = true)
    Team getLastTeam();
}
