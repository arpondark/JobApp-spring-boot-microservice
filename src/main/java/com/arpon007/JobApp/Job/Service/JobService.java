package com.arpon007.JobApp.Job.Service;

import com.arpon007.JobApp.Job.Models.Job;
import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> getAllJobs();
    Optional<Job> getJobById(Long id);
    Job createJob(Job job);
    Job updateJob(Long id, Job job);
    boolean deleteJob(Long id);
}
