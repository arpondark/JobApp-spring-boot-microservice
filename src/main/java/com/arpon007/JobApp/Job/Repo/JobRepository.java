package com.arpon007.JobApp.Job.Repo;

import com.arpon007.JobApp.Job.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // JpaRepository provides all basic CRUD operations with auto-increment ID support
    // Additional custom query methods can be added here if needed
}
