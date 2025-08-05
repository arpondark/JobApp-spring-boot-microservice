package com.arpon007.JobApp.Review.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpon007.JobApp.Company.Models.Company;
import com.arpon007.JobApp.Company.Repo.CompanyRepository;
import com.arpon007.JobApp.Review.Models.Review;
import com.arpon007.JobApp.Review.Repo.ReviewRepository;
import com.arpon007.JobApp.Review.Service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review createReview(Review review) {
        review.setId(null); // Ensure ID is null for new review to trigger auto-increment
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Optional<Review> existingReviewOpt = reviewRepository.findById(id);
        if (existingReviewOpt.isPresent()) {
            Review existingReview = existingReviewOpt.get();
            // Update only the fields that should be updated, preserve company relationship
            existingReview.setTitle(review.getTitle());
            existingReview.setDescription(review.getDescription());
            existingReview.setRating(review.getRating());
            // Keep the existing company relationship
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    @Override
    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Review> getReviewsByCompanyId(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review addReviewToCompany(Long companyId, Review review) {
        Optional<Company> companyOpt = companyRepository.findById(companyId);
        if (companyOpt.isPresent()) {
            review.setCompany(companyOpt.get());
            review.setId(null); // Ensure auto-increment for new review
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public double getAverageRatingForCompany(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        if (reviews.isEmpty()) {
            return 0.0;
        }
        return reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<Review> getReviewsByRatingRange(double minRating, double maxRating) {
        return reviewRepository.findByRatingBetween(minRating, maxRating);
    }

    @Override
    public List<Review> getReviewsWithMinimumRating(double minRating) {
        return reviewRepository.findByRatingGreaterThanEqual(minRating);
    }
}
