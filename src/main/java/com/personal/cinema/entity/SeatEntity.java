package com.personal.cinema.entity;

import com.personal.cinema.model.Seat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "seat")
public class SeatEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "row", nullable = false)
    private String row;

    @Column(name = "\"column\"", nullable = false)
    private String column;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private HallEntity hall;

    public SeatEntity() {
    }

    public SeatEntity(final UUID id, final String row, final String column, final HallEntity hall) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.hall = hall;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(final String row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(final String column) {
        this.column = column;
    }

    public HallEntity getHall() {
        return hall;
    }

    public void setHall(final HallEntity hall) {
        this.hall = hall;
    }

    public Seat toDomainModel() {
        return new Seat(id, row, column, hall.toDomainModel());
    }

    public static SeatEntity fromDomainModel(Seat seat) {
        return new SeatEntity(
                seat.getId(),
                seat.getRow(),
                seat.getColumn(),
                HallEntity.fromDomainModel(seat.getHall())
        );
    }
}
