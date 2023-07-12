package com.personal.cinema.controller;

import com.personal.cinema.model.Movie;
import com.personal.cinema.model.Review;
import com.personal.cinema.model.User;
import com.personal.cinema.request.ReviewRequest;
import com.personal.cinema.service.api.MovieService;
import com.personal.cinema.service.api.ReviewService;
import com.personal.cinema.service.api.UserService;
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
    private final MovieService movieService;
    private final UserService userService;

    public ReviewController(final ReviewService reviewService,
                            final MovieService movieService,
                            final UserService userService) {
        this.reviewService = reviewService;
        this.movieService = movieService;
        this.userService = userService;
    }

    @GetMapping
    public List<Review> list() {
        return reviewService.list();
    }

    @PostMapping
    public Review save(@RequestBody final ReviewRequest reviewRequest) {
        final Movie movie = movieService.findById(reviewRequest.movieId())
                .orElseThrow(IllegalArgumentException::new);
        final User user = userService.findById(reviewRequest.userId())
                .orElseThrow(IllegalAccessError::new);

        return reviewService.save(Review.fromRequest(reviewRequest, movie, user));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable final UUID id) {
        reviewService.deleteById(id);
    }
}
