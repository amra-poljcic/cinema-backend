package com.personal.cinema.service.impl;

import com.personal.cinema.entity.ReviewEntity;
import com.personal.cinema.model.Movie;
import com.personal.cinema.model.Review;
import com.personal.cinema.repository.ReviewRepository;
import com.personal.cinema.service.api.MovieService;
import com.personal.cinema.service.api.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieService movieService;

    public ReviewServiceImpl(final ReviewRepository reviewRepository, final MovieService movieService) {
        this.reviewRepository = reviewRepository;
        this.movieService = movieService;
    }

    @Transactional
    @Override
    public Review save(final Review review) {
        final Movie movie = review.getMovie();

        final double reviewAverage = movie.getReviewAverage().orElse(0D);
        final int reviewCount = movie.getReviewCount().orElse(0);
        final double newReviewAverage = ((reviewCount * reviewAverage) + review.getGrade()) / (reviewCount + 1);
        final int newReviewCount = reviewCount + 1;

        movieService.save(movie
                .withReviewAverage(newReviewAverage)
                .withReviewCount(newReviewCount)
        );

        final ReviewEntity reviewEntity = ReviewEntity.fromDomainModel(review);
        return reviewRepository.save(reviewEntity).toDomainModel();
    }

    @Override
    public List<Review> list() {
        return reviewRepository.findAll().stream().map(ReviewEntity::toDomainModel).toList();
    }

    @Override
    public void deleteById(final UUID id) {
        final Review review = reviewRepository.findById(id)
                .map(ReviewEntity::toDomainModel)
                .orElseThrow(IllegalArgumentException::new);

        final Movie movie = review.getMovie();

        final double reviewAverage = movie.getReviewAverage().orElse(0D);
        final int reviewCount = movie.getReviewCount().orElse(0);
        final double newReviewAverage = ((reviewCount * reviewAverage) - review.getGrade()) / (reviewCount - 1);
        final int newReviewCount = reviewCount - 1;

        movieService.save(movie
                .withReviewAverage(newReviewAverage)
                .withReviewCount(newReviewCount)
        );

        reviewRepository.deleteById(id);
    }
}
