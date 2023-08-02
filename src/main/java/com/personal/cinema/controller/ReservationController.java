package com.personal.cinema.controller;

import com.personal.cinema.model.Reservation;
import com.personal.cinema.model.Schedule;
import com.personal.cinema.model.Seat;
import com.personal.cinema.model.User;
import com.personal.cinema.request.ReservationRequest;
import com.personal.cinema.service.api.ReservationService;
import com.personal.cinema.service.api.ScheduleService;
import com.personal.cinema.service.api.SeatService;
import com.personal.cinema.service.api.UserService;
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
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final SeatService seatService;
    private final ScheduleService scheduleService;
    private final UserService userService;

    public ReservationController(final ReservationService reservationService,
                                 final SeatService seatService,
                                 final ScheduleService scheduleService,
                                 final UserService userService) {
        this.reservationService = reservationService;
        this.seatService = seatService;
        this.scheduleService = scheduleService;
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('reservation:read')")
    public List<Reservation> list() {
        return reservationService.list();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('reservation:add')")
    public Reservation save(@RequestBody final ReservationRequest reservationRequest) {
        final Seat seat = seatService.findById(reservationRequest.seatId())
                .orElseThrow(IllegalArgumentException::new);
        final Schedule schedule = scheduleService.findById(reservationRequest.scheduleId())
                .orElseThrow(IllegalArgumentException::new);
        final User user = userService.findById(reservationRequest.userId())
                .orElseThrow(IllegalArgumentException::new);

        return reservationService.save(Reservation.fromRequest(reservationRequest, seat, schedule, user));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('reservation:delete')")
    public void deleteById(@PathVariable final UUID id) {
        reservationService.deleteById(id);
    }
}
