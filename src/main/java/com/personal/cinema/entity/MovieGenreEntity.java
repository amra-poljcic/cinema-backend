package com.personal.cinema.entity;

import com.personal.cinema.model.MovieGenre;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "movie_genre")
public class MovieGenreEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieEntity movie;

    public MovieGenreEntity() {
    }

    public MovieGenreEntity(final UUID id, final GenreEntity genre, final MovieEntity movie) {
        this.id = id;
        this.genre = genre;
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(final GenreEntity genre) {
        this.genre = genre;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(final MovieEntity movie) {
        this.movie = movie;
    }

    public MovieGenre toDomainModel() {
        return new MovieGenre(id, genre.toDomainModel(), movie.toDomainModal());
    }

    public static MovieGenreEntity fromDomainModel(final MovieGenre movieGenre) {
        return new MovieGenreEntity(movieGenre.getId(), null, null);
    }
}
