package com.arpon007.JobApp.Company.Impl;

import com.arpon007.JobApp.Company.Models.Company;
import com.arpon007.JobApp.Company.Repo.CompanyRepository;
import com.arpon007.JobApp.Company.Service.CompanyService;
import com.arpon007.JobApp.Job.Models.Job;
import com.arpon007.JobApp.Job.Repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company createCompany(Company company) {
        company.setId(null); // Ensure ID is null for new company to trigger auto-increment
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        if (companyRepository.existsById(id)) {
            company.setId(id);
            return companyRepository.save(company);
        }
        return null;
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Job> getJobsByCompanyId(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            return company.get().getJobs();
        }
        return List.of();
    }

    @Override
    public Job addJobToCompany(Long companyId, Job job) {
        Optional<Company> companyOpt = companyRepository.findById(companyId);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            job.setCompany(company);
            job.setId(null); // Ensure auto-increment for new job
            return jobRepository.save(job);
        }
        return null;
    }

    @Override
    public boolean removeJobFromCompany(Long companyId, Long jobId) {
        Optional<Job> jobOpt = jobRepository.findById(jobId);
        if (jobOpt.isPresent()) {
            Job job = jobOpt.get();
            if (job.getCompany() != null && job.getCompany().getId().equals(companyId)) {
                job.setCompany(null);
                jobRepository.save(job);
                return true;
            }
        }
        return false;
    }
}
