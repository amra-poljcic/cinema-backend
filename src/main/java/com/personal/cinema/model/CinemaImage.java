package com.personal.cinema.model;

import java.util.UUID;

public class CinemaImage {
    private final UUID id;
    private final String url;
    private final Cinema cinema;

    public CinemaImage(final UUID id, final String url, final Cinema cinema) {
        this.id = id;
        this.url = url;
        this.cinema = cinema;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Cinema getCinema() {
        return cinema;
    }
}
