package com.example.task3app.service;

import com.example.task3app.dto.reviewDTO.ReviewCreateDTO;
import com.example.task3app.dto.reviewDTO.ReviewDeleteDTO;
import com.example.task3app.dto.reviewDTO.ReviewListDTO;
import com.example.task3app.exceptions.NotFoundException;
import com.example.task3app.model.Product;
import com.example.task3app.model.Review;
import com.example.task3app.repository.ProductRepo;
import com.example.task3app.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ProductRepo productRepo;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo, ProductRepo productRepo) {
        this.reviewRepo = reviewRepo;
        this.productRepo = productRepo;
    }

    /**
     * Add a review to a product.
     *
     * @param productID The ID of the product to add the review to.
     * @param review    The review to be added.
     * @return A DTO (Data Transfer Object) representing the newly created review.
     * @throws NotFoundException if the product with the specified ID is not found.
     */
    @Override
    public ReviewCreateDTO addReview(Integer productID, Review review) throws NotFoundException {
        if (productRepo.existsById(productID)) {
            Optional<Product> byId = productRepo.findById(productID);
            Product product = byId.get();
            List<Review> reviews = product.getReviews();
            reviews.add(review);
            product.setReviews(reviews);
            Product savedProduct = productRepo.save(product);
            return new ReviewCreateDTO(savedProduct.getId());
        } else throw new NotFoundException("Product with ID " + productID + " not found.");
    }

    /**
     * Delete a review from a product by product and review IDs.
     *
     * @param productID The ID of the product.
     * @param reviewID  The ID of the review to be deleted.
     * @return A DTO with information about the deleted review.
     * @throws NotFoundException if the product with the specified ID is not found.
     */
    @Override
    public ReviewDeleteDTO deleteReview(Integer productID, Integer reviewID) throws NotFoundException {
        if (productRepo.existsById(productID)) {
            Optional<Product> productOptional = productRepo.findById(productID);
            Product product = productOptional.get();
            List<Review> reviews = product.getReviews();
            Optional<Review> byId = reviewRepo.findById(reviewID);
            Review review = byId.get();
            reviews.remove(review);
            productRepo.save(product);
            return new ReviewDeleteDTO(reviewID);
        } else throw new NotFoundException("Product with ID " + productID + " not found.");
    }

    /**
     * Get a list of reviews for a specific product.
     *
     * @param productID The ID of the product.
     * @return A DTO containing a list of reviews associated with the product.
     * @throws NotFoundException if the product with the specified ID is not found.
     */
    @Override
    public ReviewListDTO getReviewByProduct(Integer productID) throws NotFoundException {
        if (productRepo.existsById(productID)) {
            Optional<Product> byId = productRepo.findById(productID);
            Product product = byId.get();
            List<Review> reviews = product.getReviews();
            ReviewListDTO reviewListDTO = new ReviewListDTO();
            reviewListDTO.setReviewList(reviews);
            return reviewListDTO;
        } else throw new NotFoundException("Product with ID " + productID + " not found.");
    }
}
