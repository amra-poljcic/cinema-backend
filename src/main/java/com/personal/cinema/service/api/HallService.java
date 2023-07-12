package com.personal.cinema.service.api;

import com.personal.cinema.model.Hall;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HallService {

    Hall save(final Hall hall);

    List<Hall> list();

    void deleteById(final UUID id);

    Optional<Hall> findById(UUID id);
}
