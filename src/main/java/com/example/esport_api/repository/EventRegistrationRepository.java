package com.example.esport_api.repository;

import com.example.esport_api.entity.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author udarasan
 * @TimeStamp 2023-03-03 15:54
 * @ProjectDetails esport_api
 */
@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration,Integer> {
}
