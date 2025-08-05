package com.arpon007.JobApp.Review.Controllers;

import com.arpon007.JobApp.Review.Models.Review;
import com.arpon007.JobApp.Review.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // GET /api/companies/{companyId}/reviews - Get all reviews for a specific company
    @GetMapping("/companies/{companyId}/reviews")
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable Long companyId) {
        List<Review> reviews = reviewService.getReviewsByCompanyId(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // GET /api/companies/{companyId}/reviews/{reviewId} - Get a specific review for a company
    @GetMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> getCompanyReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Optional<Review> review = reviewService.getReviewById(reviewId);
        if (review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST /api/companies/{companyId}/reviews - Add a review to a specific company
    @PostMapping("/companies/{companyId}/reviews")
    public ResponseEntity<Review> addReviewToCompany(@PathVariable Long companyId, @RequestBody Review review) {
        Review createdReview = reviewService.addReviewToCompany(companyId, review);
        if (createdReview != null) {
            return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT /api/companies/{companyId}/reviews/{reviewId} - Update a specific review for a company
    @PutMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> updateCompanyReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(reviewId, review);
        if (updatedReview != null) {
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /api/companies/{companyId}/reviews/{reviewId} - Delete a specific review for a company
    @DeleteMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Void> deleteCompanyReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean deleted = reviewService.deleteReview(reviewId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Global review endpoints
    // GET /api/reviews - Get all reviews
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // GET /api/reviews/{id} - Get review by ID
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT /api/reviews/{id} - Update existing review
    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(id, review);
        if (updatedReview != null) {
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /api/reviews/{id} - Delete review by ID
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        boolean deleted = reviewService.deleteReview(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
