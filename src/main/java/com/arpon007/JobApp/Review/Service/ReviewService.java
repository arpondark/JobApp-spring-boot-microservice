package com.arpon007.JobApp.Review.Service;

import com.arpon007.JobApp.Review.Models.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();
    Optional<Review> getReviewById(Long id);
    Review createReview(Review review);
    Review updateReview(Long id, Review review);
    boolean deleteReview(Long id);

    // Company-specific review operations
    List<Review> getReviewsByCompanyId(Long companyId);
    Review addReviewToCompany(Long companyId, Review review);
    double getAverageRatingForCompany(Long companyId);

    // Rating-based queries
    List<Review> getReviewsByRatingRange(double minRating, double maxRating);
    List<Review> getReviewsWithMinimumRating(double minRating);
}
