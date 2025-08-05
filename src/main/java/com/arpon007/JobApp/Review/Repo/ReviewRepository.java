package com.arpon007.JobApp.Review.Repo;

import com.arpon007.JobApp.Review.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Find reviews by company ID
    List<Review> findByCompanyId(Long companyId);

    // Find reviews by rating range
    List<Review> findByRatingGreaterThanEqual(double rating);
    List<Review> findByRatingLessThanEqual(double rating);
    List<Review> findByRatingBetween(double minRating, double maxRating);
}
