package com.personal.cinema.service.api;

import com.personal.cinema.model.Cinema;

import java.util.List;
import java.util.UUID;

public interface CinemaService {

    Cinema save(final Cinema cinema);

    List<Cinema> list();

    void deleteById(final UUID cinemaId);
}
