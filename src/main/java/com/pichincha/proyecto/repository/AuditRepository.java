package com.pichincha.proyecto.repository;

import com.pichincha.proyecto.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
