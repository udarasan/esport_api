package com.example.esport_api.repository;

import com.example.esport_api.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 11:17
 * @ProjectDetails esport_api
 */
@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
}
