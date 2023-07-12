package com.personal.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personal.cinema.request.SeatRequest;

import java.util.UUID;

public class Seat {
    private final UUID id;
    private final String row;
    private final String column;
    private final Hall hall;

    public Seat(final String row, final String column, final Hall hall) {
        this(null, row, column, hall);
    }

    public Seat(final UUID id, final String row, final String column, final Hall hall) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.hall = hall;
    }

    public UUID getId() {
        return id;
    }

    public String getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    @JsonIgnore
    public Hall getHall() {
        return hall;
    }

    public UUID getHallId() {
        return hall.getId();
    }

    public static Seat fromRequest(final SeatRequest seatRequest, final Hall hall) {
        return new Seat(seatRequest.row(), seatRequest.column(), hall);
    }
}
