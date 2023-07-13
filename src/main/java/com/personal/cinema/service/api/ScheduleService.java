package com.personal.cinema.service.api;

import com.personal.cinema.model.Schedule;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ScheduleService {

    Schedule save(Schedule schedule);

    List<Schedule> list();

    void deleteById(UUID id);

    Optional<Schedule> findById(UUID id);
}
