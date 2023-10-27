package com.example.task3app.controller;

import com.example.task3app.dto.reviewDTO.ReviewCreateDTO;
import com.example.task3app.dto.reviewDTO.ReviewDeleteDTO;
import com.example.task3app.dto.reviewDTO.ReviewListDTO;
import com.example.task3app.model.Review;
import com.example.task3app.service.ReviewService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Create a new review for a product
    @PostMapping("/products/{productID}")
    @SneakyThrows
    ResponseEntity<ReviewCreateDTO> saveReview(@PathVariable Integer productID, @RequestBody Review review) {
        return new ResponseEntity<>(reviewService.addReview(productID, review), HttpStatus.CREATED);
    }

    // Delete a review for a product by product and review IDs
    @DeleteMapping("/products/{productID}/{reviewID}")
    @SneakyThrows
    ResponseEntity<ReviewDeleteDTO> deleteReview(@PathVariable Integer productID, @PathVariable Integer reviewID) {
        return new ResponseEntity<>(reviewService.deleteReview(productID, reviewID), HttpStatus.CREATED);
    }

    // Get reviews for a specific product
    @GetMapping("/products/{productID}/review")
    @SneakyThrows
    ResponseEntity<ReviewListDTO> getReviewByProduct(@PathVariable Integer productID) {
        return new ResponseEntity<>(reviewService.getReviewByProduct(productID), HttpStatus.OK);
    }
}
