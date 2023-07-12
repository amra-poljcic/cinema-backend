package com.personal.cinema.service.impl;

import com.personal.cinema.entity.MovieEntity;
import com.personal.cinema.model.Movie;
import com.personal.cinema.repository.MovieRepository;
import com.personal.cinema.service.api.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> findById(final UUID id) {
        return movieRepository.findById(id).map(MovieEntity::toDomainModal);
    }

    @Override
    public Movie save(final Movie movie) {
        return movieRepository.save(MovieEntity.fromDomainModel(movie)).toDomainModal();
    }

    @Override
    public List<Movie> list() {
        return movieRepository.findAll().stream().map(MovieEntity::toDomainModal).toList();
    }

    @Override
    public void deleteById(final UUID id) {
        movieRepository.deleteById(id);
    }
}