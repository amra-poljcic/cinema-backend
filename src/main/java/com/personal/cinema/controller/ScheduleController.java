package com.personal.cinema.controller;

import com.personal.cinema.model.Hall;
import com.personal.cinema.model.Movie;
import com.personal.cinema.model.Schedule;
import com.personal.cinema.request.ScheduleRequest;
import com.personal.cinema.service.api.HallService;
import com.personal.cinema.service.api.MovieService;
import com.personal.cinema.service.api.ScheduleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final MovieService movieService;
    private final HallService hallService;

    public ScheduleController(final ScheduleService scheduleService,
                              final MovieService movieService,
                              final HallService hallService) {
        this.scheduleService = scheduleService;
        this.movieService = movieService;
        this.hallService = hallService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('schedule:read')")
    public List<Schedule> list() {
        return scheduleService.list();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('schedule:add')")
    public Schedule save(@RequestBody final ScheduleRequest rawScheduleRequest) {
        final Movie movie = movieService.findById(rawScheduleRequest.movieId())
                .orElseThrow(IllegalAccessError::new);

        final ScheduleRequest scheduleRequest;
        if (rawScheduleRequest.endTime() != null) {
            scheduleRequest = rawScheduleRequest;
        } else {
            scheduleRequest = rawScheduleRequest.withEndTime(
                    rawScheduleRequest.startTime()
                            .plus(movie.getDuration())
                            .plus(Schedule.DEFAULT_PAUSE_DURATION)
            );
        }

        if (scheduleRequest.startTime().isAfter(scheduleRequest.endTime())
            || scheduleRequest.startTime().isAfter(Instant.now())) {
            throw new IllegalArgumentException("Invalid schedule start time");
        }

        final Hall hall = hallService.findById(scheduleRequest.hallId())
                .orElseThrow(IllegalAccessError::new);

        return scheduleService.save(Schedule.fromRequest(scheduleRequest, movie, hall));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('schedule:delete')")
    public void deleteById(@PathVariable final UUID id) {
        scheduleService.deleteById(id);
    }
}
