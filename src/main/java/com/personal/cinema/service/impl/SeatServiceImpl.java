package com.personal.cinema.service.impl;

import com.personal.cinema.entity.SeatEntity;
import com.personal.cinema.model.Seat;
import com.personal.cinema.repository.SeatRepository;
import com.personal.cinema.service.api.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(final SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat save(final Seat seat) {
        final long hallSeatsCount = seatRepository.countByHallId(seat.getHallId());

        if (hallSeatsCount >= seat.getHall().getCapacity()) {
            throw new IllegalArgumentException("Max seat capacity of the hall has been reached");
        }

        return seatRepository.save(SeatEntity.fromDomainModel(seat)).toDomainModel();
    }

    @Override
    public List<Seat> list() {
        return seatRepository.findAll().stream().map(SeatEntity::toDomainModel).toList();
    }

    @Override
    public List<Seat> list(final UUID hallId) {
        return seatRepository.findAllByHallId(hallId).stream().map(SeatEntity::toDomainModel).toList();
    }

    @Override
    public void deleteById(final UUID id) {
        seatRepository.deleteById(id);
    }

    @Override
    public Optional<Seat> findById(final UUID id) {
        return seatRepository.findById(id).map(SeatEntity::toDomainModel);
    }
}
