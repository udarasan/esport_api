package com.example.esport_api.repository;

import com.example.esport_api.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
}
