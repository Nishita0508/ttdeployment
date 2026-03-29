package com.example.demo.repository;

import com.example.demo.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {

    // Find careers by domain (case-insensitive)
    List<Career> findByDomainIgnoreCase(String domain);

    // Find careers by domain and branch (case-insensitive)
    List<Career> findByDomainIgnoreCaseAndBranchIgnoreCase(String domain, String branch);

    // Optional: find by description containing a keyword
    List<Career> findByDescriptionContainingIgnoreCase(String keyword);

    // Optional: find by branch containing a keyword
    List<Career> findByBranchContainingIgnoreCase(String keyword);
}