package com.personal.cinema.controller;

import com.personal.cinema.model.Cinema;
import com.personal.cinema.service.api.CinemaService;
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
@RequestMapping("/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(final CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('cinema:read')")
    public List<Cinema> list() {
        return cinemaService.list();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('cinema:add')")
    public Cinema save(@RequestBody final Cinema cinema) {
        return cinemaService.save(cinema);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('cinema:delete')")
    public void deleteById(@PathVariable final UUID id) {
        cinemaService.deleteById(id);
    }
}
