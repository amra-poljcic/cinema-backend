package com.personal.cinema.service.impl;

import com.personal.cinema.entity.ScheduleEntity;
import com.personal.cinema.model.Schedule;
import com.personal.cinema.repository.ScheduleRepository;
import com.personal.cinema.service.api.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(final ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule save(final Schedule schedule) {
        final boolean hallBooked = scheduleRepository
                .overlapExists(schedule.getStartTime(), schedule.getEndTime(), schedule.getHall().getId());

        if (hallBooked) {
            throw new IllegalArgumentException("Hall is booked for this schedule");
        }

        return scheduleRepository
                .save(ScheduleEntity.fromDomainModel(schedule))
                .toDomainModel();
    }

    @Override
    public List<Schedule> list() {
        return scheduleRepository.findAll().stream().map(ScheduleEntity::toDomainModel).toList();
    }

    @Override
    public void deleteById(final UUID id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Optional<Schedule> findById(final UUID id) {
        return scheduleRepository.findById(id).map(ScheduleEntity::toDomainModel);
    }
}
