package com.personal.cinema.service.impl;

import com.personal.cinema.entity.ReservationEntity;
import com.personal.cinema.model.Reservation;
import com.personal.cinema.repository.ReservationRepository;
import com.personal.cinema.service.api.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(final Reservation reservation) {
        final boolean reservedSeat = reservationRepository.existsBySeatId(reservation.getSeat().getId());

        if (reservedSeat) {
            throw new IllegalArgumentException("Seat is already reserved");
        }

        final long reservationNumber = reservationRepository.countByScheduleIdAndUserId(
                reservation.getSchedule().getId(),
                reservation.getUser().getId()
        );

        if (reservationNumber >= 10) {
            throw new IllegalArgumentException("You can not have more than 10 reservations");
        }

        return reservationRepository.save(ReservationEntity.fromDomainModel(reservation)).toDomainModel();
    }

    @Override
    public List<Reservation> list() {
        return reservationRepository.findAll().stream().map(ReservationEntity::toDomainModel).toList();
    }

    @Override
    public void deleteById(final UUID id) {
        reservationRepository.deleteById(id);
    }
}
