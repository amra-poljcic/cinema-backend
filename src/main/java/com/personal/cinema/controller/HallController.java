package com.personal.cinema.controller;

import com.personal.cinema.model.Hall;
import com.personal.cinema.model.Seat;
import com.personal.cinema.request.SeatRequest;
import com.personal.cinema.service.api.HallService;
import com.personal.cinema.service.api.SeatService;
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
@RequestMapping(value = "/hall")
public class HallController {

    private final HallService hallService;
    private final SeatService seatService;

    public HallController(final HallService hallService, final SeatService seatService) {
        this.hallService = hallService;
        this.seatService = seatService;
    }

    @GetMapping
    public List<Hall> list() {
        return hallService.list();
    }

    @GetMapping("{id}/seat")
    public List<Seat> listSeats(@PathVariable final UUID id) {
        return seatService.list(id);
    }

    @PostMapping
    public Hall save(@RequestBody final Hall hall) {
        return hallService.save(hall);
    }

    @PostMapping("{id}/seat")
    public Seat saveSeat(@PathVariable final UUID id, @RequestBody final SeatRequest seatRequest) {
        final Hall hall = hallService.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        final Seat seat = Seat.fromRequest(seatRequest, hall);

        return seatService.save(seat);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final UUID id) {
        hallService.deleteById(id);
    }
}
