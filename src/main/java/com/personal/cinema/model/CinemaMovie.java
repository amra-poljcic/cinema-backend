package com.personal.cinema.model;

import java.util.UUID;

public class CinemaMovie {
    private final UUID id;
    private final Cinema cinema;
    private final Movie movie;

    public CinemaMovie(final UUID id, final Cinema cinema, final Movie movie) {
        this.id = id;
        this.cinema = cinema;
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Movie getMovie() {
        return movie;
    }
}
