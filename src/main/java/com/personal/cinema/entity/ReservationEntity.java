package com.personal.cinema.entity;

import com.personal.cinema.model.Reservation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "date")
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seat;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity schedule;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ReservationEntity() {
    }

    public ReservationEntity(final UUID id,
                             final boolean completed,
                             final Instant date,
                             final SeatEntity seat,
                             final ScheduleEntity schedule,
                             final UserEntity user) {
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

    public void setId(final UUID id) {
        this.id = id;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(final boolean completed) {
        this.completed = completed;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(final Instant date) {
        this.date = date;
    }

    public SeatEntity getSeat() {
        return seat;
    }

    public void setSeat(final SeatEntity seat) {
        this.seat = seat;
    }

    public ScheduleEntity getSchedule() {
        return schedule;
    }

    public void setSchedule(final ScheduleEntity schedule) {
        this.schedule = schedule;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(final UserEntity user) {
        this.user = user;
    }

    public Reservation toDomainModel() {
        return new Reservation(
                id,
                completed,
                date,
                seat.toDomainModel(),
                schedule.toDomainModel(),
                user.toDomainModel()
        );
    }

    public static ReservationEntity fromDomainModel(Reservation reservation) {
        return new ReservationEntity(
                reservation.getId(),
                reservation.getCompleted(),
                reservation.getDate(),
                SeatEntity.fromDomainModel(reservation.getSeat()),
                ScheduleEntity.fromDomainModel(reservation.getSchedule()),
                UserEntity.fromDomainModel(reservation.getUser())
        );
    }
}
