package com.personal.cinema.model;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Movie {
    private final UUID id;
    private final String name;
    private final String description;
    private final Double reviewAverage;
    private final Integer reviewCount;
    private final Duration duration;
    private final int year;
    private final List<Image> images;
    private final List<MovieGenre> genres;

    public Movie(final UUID id,
                 final String name,
                 final String description,
                 final Double reviewAverage,
                 final Integer reviewCount,
                 final Duration duration,
                 final int year,
                 final List<Image> images,
                 final List<MovieGenre> genres) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reviewAverage = reviewAverage;
        this.reviewCount = reviewCount;
        this.duration = duration;
        this.year = year;
        this.images = images;
        this.genres = genres;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getYear() {
        return year;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<MovieGenre> getGenres() {
        return genres;
    }

    public Optional<Double> getReviewAverage() {
        return Optional.ofNullable(reviewAverage);
    }

    public Movie withReviewAverage(final Double reviewAverage) {
        return new Movie(
                this.id,
                this.name,
                this.description,
                reviewAverage,
                this.reviewCount,
                this.duration,
                this.year,
                this.images,
                this.genres
        );
    }

    public Optional<Integer> getReviewCount() {
        return Optional.ofNullable(reviewCount);
    }

    public Movie withReviewCount(final Integer reviewCount) {
        return new Movie(
                this.id,
                this.name,
                this.description,
                this.reviewAverage,
                reviewCount,
                this.duration,
                this.year,
                this.images,
                this.genres
        );
    }
}
