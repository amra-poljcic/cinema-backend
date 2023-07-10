package com.personal.cinema.model;

import java.util.UUID;

public class Seat {
    private final UUID id;
    private final String row;
    private final String column;
    private final Hall hall;

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

    public Hall getHall() {
        return hall;
    }
}
