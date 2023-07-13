package com.personal.cinema.model;

import com.personal.cinema.request.ScheduleRequest;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class Schedule {
    public static final Duration DEFAULT_PAUSE_DURATION = Duration.ofMinutes(30);
    private final UUID id;
    private final Instant startTime;
    private final Instant endTime;
    private final double price;
    private final Movie movie;
    private final Hall hall;

    public Schedule(final Instant startTime,
                    final Instant endTime,
                    final double price,
                    final Movie movie,
                    final Hall hall) {
        this(null, startTime, endTime, price, movie, hall);
    }

    public Schedule(final UUID id,
                    final Instant startTime,
                    final Instant endTime,
                    final double price,
                    final Movie movie,
                    final Hall hall) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.movie = movie;
        this.hall = hall;
    }

    public UUID getId() {
        return id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
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

    public static Schedule fromRequest(ScheduleRequest scheduleRequest, Movie movie, Hall hall) {
        return new Schedule(
                scheduleRequest.startTime(),
                scheduleRequest.endTime(),
                scheduleRequest.price(),
                movie,
                hall
        );
    }
}
