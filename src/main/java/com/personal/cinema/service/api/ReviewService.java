package com.personal.cinema.service.api;

import com.personal.cinema.model.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {

    Review save(Review review);

    List<Review> list();

    void deleteById(UUID id);
}
