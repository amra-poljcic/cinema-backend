package com.personal.cinema.repository;

import com.personal.cinema.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, UUID> {

    @Query("""
            SELECT count(s) > 0 FROM ScheduleEntity s
            WHERE (:hall_id = s.hall.id) AND (:start <= s.endTime) AND (:end >= s.startTime)
            """)
    boolean overlapExists(@Param("start") Instant start, @Param("end") Instant end, @Param("hall_id") UUID hallId);
}
