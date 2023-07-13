package com.personal.cinema.entity;

import com.personal.cinema.model.Schedule;
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
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private HallEntity hall;

    public ScheduleEntity() {
    }

    public ScheduleEntity(final UUID id,
                          final Instant startTime,
                          final Instant endTime,
                          final double price,
                          final MovieEntity movie,
                          final HallEntity hall) {
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

    public void setId(final UUID id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(final Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(final Instant endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(final MovieEntity movie) {
        this.movie = movie;
    }

    public HallEntity getHall() {
        return hall;
    }

    public void setHall(final HallEntity hall) {
        this.hall = hall;
    }

    public Schedule toDomainModel() {
        return new Schedule(id, startTime, endTime, price, movie.toDomainModal(), hall.toDomainModel());
    }

    public static ScheduleEntity fromDomainModel(Schedule schedule) {
        return new ScheduleEntity(
                schedule.getId(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getPrice(),
                MovieEntity.fromDomainModel(schedule.getMovie()),
                HallEntity.fromDomainModel(schedule.getHall())
        );
    }
}
