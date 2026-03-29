package com.example.demo.repository;

import com.example.demo.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Certification findByNameIgnoreCase(String name);
}