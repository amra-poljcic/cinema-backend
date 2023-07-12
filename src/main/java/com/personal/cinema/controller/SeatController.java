package com.personal.cinema.controller;

import com.personal.cinema.model.Seat;
import com.personal.cinema.service.api.SeatService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;

    public SeatController(final SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> list() {
        return seatService.list();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable final UUID id) {
        seatService.deleteById(id);
    }
}
