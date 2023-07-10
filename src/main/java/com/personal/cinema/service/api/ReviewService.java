package com.personal.cinema.service.api;

import com.personal.cinema.model.Review;
import com.personal.cinema.request.ReviewRequest;

import java.util.List;
import java.util.UUID;

public interface ReviewService {

    Review save(ReviewRequest reviewRequest);

    List<Review> list();

    void deleteById(UUID id);
}
