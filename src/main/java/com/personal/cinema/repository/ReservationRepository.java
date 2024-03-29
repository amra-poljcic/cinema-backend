package com.personal.cinema.repository;

import com.personal.cinema.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID> {

    long countByScheduleIdAndUserId(UUID scheduleId, UUID userId);

    boolean existsBySeatId(UUID id);
}
