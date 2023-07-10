package com.personal.cinema.controller;

import com.personal.cinema.model.Review;
import com.personal.cinema.request.ReviewRequest;
import com.personal.cinema.service.api.ReviewService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(final ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> list() {
        return reviewService.list();
    }

    @PostMapping
    public Review save(@RequestBody final ReviewRequest reviewRequest) {
        return reviewService.save(reviewRequest);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable final UUID id) {
        reviewService.deleteById(id);
    }
}
