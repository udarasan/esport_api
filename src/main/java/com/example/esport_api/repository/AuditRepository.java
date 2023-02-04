package com.example.esport_api.repository;

import com.example.esport_api.entity.AuditSection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author udarasan
 * @TimeStamp 2023-02-04 09:36
 * @ProjectDetails esport_api
 */
public interface AuditRepository extends JpaRepository<AuditSection,Integer> {
}
