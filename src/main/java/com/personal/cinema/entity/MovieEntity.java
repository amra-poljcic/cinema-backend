package com.personal.cinema.entity;

import com.personal.cinema.model.Movie;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "review_average")
    private Double reviewAverage;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "duration", nullable = false)
    private Duration duration;

    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieImageEntity> images;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieGenreEntity> genres;

    public MovieEntity() {
    }

    public MovieEntity(final UUID id,
                       final String name,
                       final String description,
                       final Double reviewAverage,
                       final Integer reviewCount,
                       final Duration duration,
                       final int year,
                       final List<MovieImageEntity> images,
                       final List<MovieGenreEntity> genres) {
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

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Optional<Double> getReviewAverage() {
        return Optional.ofNullable(reviewAverage);
    }

    public void setReviewAverage(final Double reviewAverage) {
        this.reviewAverage = reviewAverage;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(final Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(final Duration duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public List<MovieImageEntity> getImages() {
        return images;
    }

    public void setImages(final List<MovieImageEntity> images) {
        this.images = images;
    }

    public List<MovieGenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(final List<MovieGenreEntity> genres) {
        this.genres = genres;
    }

    public Movie toDomainModal() {
        return new Movie(
                id,
                name,
                description,
                reviewAverage,
                reviewCount,
                duration,
                year,
                images.stream().map(MovieImageEntity::toDomainModel).toList(),
                genres.stream().map(MovieGenreEntity::toDomainModel).toList()
        );
    }

    public static MovieEntity fromDomainModel(final Movie movie) {
        return new MovieEntity(
                movie.getId(),
                movie.getName(),
                movie.getDescription(),
                movie.getReviewAverage().orElse(0D),
                movie.getReviewCount().orElse(0),
                movie.getDuration(),
                movie.getYear(),
                movie.getImages().stream().map(MovieImageEntity::fromDomainModel).toList(),
                movie.getGenres().stream().map(MovieGenreEntity::fromDomainModel).toList()
        );
    }
}
