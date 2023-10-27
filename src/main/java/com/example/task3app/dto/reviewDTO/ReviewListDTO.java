package com.example.task3app.dto.reviewDTO;

import com.example.task3app.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListDTO {

    List<Review> reviewList;
}
