package com.personal.cinema.service.api;

import com.personal.cinema.model.Movie;

import java.util.Optional;
import java.util.UUID;

public interface MovieService {
    Optional<Movie> findById(UUID id);

    Movie save(Movie movie);
}
