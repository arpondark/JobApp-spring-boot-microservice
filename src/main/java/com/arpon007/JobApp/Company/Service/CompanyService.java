package com.arpon007.JobApp.Company.Service;

import com.arpon007.JobApp.Company.Models.Company;
import com.arpon007.JobApp.Job.Models.Job;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(Long id);
    Company createCompany(Company company);
    Company updateCompany(Long id, Company company);
    boolean deleteCompany(Long id);

    // Additional methods for company-job relationships
    List<Job> getJobsByCompanyId(Long companyId);
    Job addJobToCompany(Long companyId, Job job);
    boolean removeJobFromCompany(Long companyId, Long jobId);
}
