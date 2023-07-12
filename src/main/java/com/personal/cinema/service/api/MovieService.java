package com.personal.cinema.service.api;

import com.personal.cinema.model.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieService {
    Optional<Movie> findById(UUID id);

    Movie save(Movie movie);

    List<Movie> list();

    void deleteById(UUID id);
}
