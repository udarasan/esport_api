package com.example.esport_api.repository;

import com.example.esport_api.entity.EventRegistration;
import com.example.esport_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration,Integer> {
    //@Query(value = "SELECT * FROM eventregistration WHERE username=?1",nativeQuery = true)
    List<EventRegistration> findAllByUsername(User username);
}
