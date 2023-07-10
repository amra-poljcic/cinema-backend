package com.personal.cinema.entity;

import com.personal.cinema.model.CinemaMovie;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "cinema_movie")
public class CinemaMovieEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaEntity cinema;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    public CinemaMovieEntity() {
    }

    public CinemaMovieEntity(final UUID id, final CinemaEntity cinema, final MovieEntity movie) {
        this.id = id;
        this.cinema = cinema;
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public void setCinema(final CinemaEntity cinema) {
        this.cinema = cinema;
    }

    public void setMovie(final MovieEntity movie) {
        this.movie = movie;
    }

    public CinemaEntity getCinema() {
        return cinema;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public CinemaMovie toDomainModal() {
        return new CinemaMovie(id, cinema.toDomainModel(), movie.toDomainModal());
    }

    public static CinemaMovieEntity fromDomainModel(CinemaMovie cinemaMovie) {
        return new CinemaMovieEntity(
                cinemaMovie.getId(),
                CinemaEntity.fromDomainModel(cinemaMovie.getCinema()),
                MovieEntity.fromDomainModel(cinemaMovie.getMovie())
        );
    }
}
