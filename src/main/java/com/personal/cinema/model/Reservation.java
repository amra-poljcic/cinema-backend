package com.personal.cinema.model;

import java.time.Instant;
import java.util.UUID;

public class Reservation {
    private final UUID id;
    private final boolean completed;
    private final Instant date;
    private final Seat seat;
    private final Schedule schedule;
    private final User user;

    public Reservation(final UUID id,
                       final boolean completed,
                       final Instant date,
                       final Seat seat,
                       final Schedule schedule,
                       final User user) {
        this.id = id;
        this.completed = completed;
        this.date = date;
        this.seat = seat;
        this.schedule = schedule;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public boolean getCompleted() {
        return completed;
    }

    public Instant getDate() {
        return date;
    }

    public Seat getSeat() {
        return seat;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public User getUser() {
        return user;
    }
}
