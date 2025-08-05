package com.arpon007.JobApp.Job.impl;

import com.arpon007.JobApp.Job.Models.Job;
import com.arpon007.JobApp.Job.Repo.JobRepository;
import com.arpon007.JobApp.Job.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job createJob(Job job) {
        job.setId(null); // Ensure ID is null for new job to trigger auto-increment
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        if (jobRepository.existsById(id)) {
            job.setId(id);
            return jobRepository.save(job);
        }
        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
