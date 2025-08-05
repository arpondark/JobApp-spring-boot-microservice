package com.arpon007.JobApp.Company.Controller;

import com.arpon007.JobApp.Company.Models.Company;
import com.arpon007.JobApp.Company.Service.CompanyService;
import com.arpon007.JobApp.Job.Models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // GET /api/companies - Get all companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    // GET /api/companies/{id} - Get company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.getCompanyById(id);
        if (company.isPresent()) {
            return new ResponseEntity<>(company.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST /api/companies - Create a new company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.createCompany(company);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    // PUT /api/companies/{id} - Update existing company
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompany(id, company);
        if (updatedCompany != null) {
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /api/companies/{id} - Delete company by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        boolean deleted = companyService.deleteCompany(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET /api/companies/{id}/jobs - Get all jobs for a specific company
    @GetMapping("/{id}/jobs")
    public ResponseEntity<List<Job>> getJobsByCompanyId(@PathVariable Long id) {
        List<Job> jobs = companyService.getJobsByCompanyId(id);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    // POST /api/companies/{id}/jobs - Add a job to a specific company
    @PostMapping("/{id}/jobs")
    public ResponseEntity<Job> addJobToCompany(@PathVariable Long id, @RequestBody Job job) {
        Job createdJob = companyService.addJobToCompany(id, job);
        if (createdJob != null) {
            return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /api/companies/{companyId}/jobs/{jobId} - Remove job from company
    @DeleteMapping("/{companyId}/jobs/{jobId}")
    public ResponseEntity<Void> removeJobFromCompany(@PathVariable Long companyId, @PathVariable Long jobId) {
        boolean removed = companyService.removeJobFromCompany(companyId, jobId);
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
