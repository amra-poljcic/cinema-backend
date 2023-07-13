package com.personal.cinema.service.api;

import com.personal.cinema.model.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationService {

    Reservation save(Reservation reservation);

    List<Reservation> list();

    void deleteById(UUID id);
}
