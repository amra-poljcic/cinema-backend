package com.personal.cinema.service.api;

import com.personal.cinema.model.Seat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeatService {

    Seat save(Seat seat);

    List<Seat> list();

    List<Seat> list(final UUID hallId);

    void deleteById(UUID id);

    Optional<Seat> findById(UUID id);
}
