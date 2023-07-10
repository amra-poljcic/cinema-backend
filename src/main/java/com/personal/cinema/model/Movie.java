package com.personal.cinema.model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Movie {
    private final UUID id;
    private final String name;
    private final String description;
    private final Double reviewAverage;
    private final Integer reviewCount;
    private final String length;
    private final int year;
    private final List<MovieImage> images;
    private final List<MovieGenre> genres;

    public Movie(final UUID id,
                 final String name,
                 final String description,
                 final Double reviewAverage,
                 final Integer reviewCount,
                 final String length,
                 final int year,
                 final List<MovieImage> images,
                 final List<MovieGenre> genres) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reviewAverage = reviewAverage;
        this.reviewCount = reviewCount;
        this.length = length;
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

    public String getLength() {
        return length;
    }

    public List<MovieImage> getImages() {
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
                this.length,
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
                this.length,
                this.year,
                this.images,
                this.genres
        );
    }

    public int getYear() {
        return year;
    }
}
