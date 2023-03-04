package com.example.esport_api.repository;

import com.example.esport_api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author udarasan
 * @TimeStamp 2023-03-04 16:32
 * @ProjectDetails esport_api
 */
@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
}
