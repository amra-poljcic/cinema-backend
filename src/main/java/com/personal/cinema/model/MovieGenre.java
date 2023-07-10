package com.personal.cinema.model;

import java.util.UUID;

public class MovieGenre {
    private final UUID id;
    private final Genre genre;
    private final Movie movie;

    public MovieGenre(final UUID id, final Genre genre, final Movie movie) {
        this.id = id;
        this.genre = genre;
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public Genre getGenre() {
        return genre;
    }

    public Movie getMovie() {
        return movie;
    }
}
