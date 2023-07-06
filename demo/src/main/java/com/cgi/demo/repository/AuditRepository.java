package com.cgi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.demo.domain.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long>{

}
