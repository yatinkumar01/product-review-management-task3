package com.example.task3app.service;

import com.example.task3app.dto.reviewDTO.ReviewCreateDTO;
import com.example.task3app.dto.reviewDTO.ReviewDeleteDTO;
import com.example.task3app.dto.reviewDTO.ReviewListDTO;
import com.example.task3app.exceptions.NotFoundException;
import com.example.task3app.model.Review;

public interface ReviewService {

    public ReviewCreateDTO addReview(Integer productID, Review review) throws NotFoundException;

    public ReviewDeleteDTO deleteReview(Integer productID, Integer reviewID) throws NotFoundException;

    public ReviewListDTO getReviewByProduct(Integer productID) throws NotFoundException;
}
