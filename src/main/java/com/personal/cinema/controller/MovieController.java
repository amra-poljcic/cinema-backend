package com.personal.cinema.controller;

import com.personal.cinema.model.Movie;
import com.personal.cinema.service.api.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('movie:read')")
    public List<Movie> list() {
        return movieService.list();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('movie:add')")
    public Movie save(@RequestBody final Movie movie) {
        return movieService.save(movie);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('movie:delete')")
    public void deleteById(@PathVariable final UUID id) {
        movieService.deleteById(id);
    }
}
