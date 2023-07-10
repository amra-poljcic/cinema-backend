package com.personal.cinema.model;

import java.util.UUID;

public class MovieImage {
    private final UUID id;
    private final String url;
    private final Movie movie;

    public MovieImage(final UUID id, final String url, final Movie movie) {
        this.id = id;
        this.url = url;
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Movie getMovie() {
        return movie;
    }
}
