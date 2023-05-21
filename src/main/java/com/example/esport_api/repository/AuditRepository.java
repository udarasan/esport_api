package com.example.esport_api.repository;

import com.example.esport_api.entity.AuditSection;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuditRepository extends JpaRepository<AuditSection,Integer> {
}
