package com.personal.cinema.model;

import java.time.Instant;
import java.util.UUID;

public class Schedule {
    private final UUID id;
    private final Instant date;
    private final double price;
    private final Movie movie;
    private final Hall hall;

    public Schedule(final UUID id, final Instant date, final double price, final Movie movie, final Hall hall) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.movie = movie;
        this.hall = hall;
    }

    public UUID getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }
}
