package com.personal.cinema.entity;

import com.personal.cinema.model.MovieImage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "movie_image")
public class MovieImageEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieEntity movie;

    public MovieImageEntity() {
    }

    public MovieImageEntity(final UUID id, final String url, final MovieEntity movie) {
        this.id = id;
        this.url = url;
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(final MovieEntity movie) {
        this.movie = movie;
    }

    public MovieImage toDomainModel() {
        return new MovieImage(id, url, movie.toDomainModal());
    }

    public static MovieImageEntity fromDomainModel(final MovieImage movieImage) {
        return new MovieImageEntity(movieImage.getId(), movieImage.getUrl(), null);
    }
}
