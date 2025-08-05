package com.arpon007.JobApp.Company.Repo;

import com.arpon007.JobApp.Company.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    // JpaRepository provides all basic CRUD operations with auto-increment ID support
    // Additional custom query methods can be added here if needed
}
