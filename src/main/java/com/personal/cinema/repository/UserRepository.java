package com.personal.cinema.repository;

import com.personal.cinema.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, java.util.UUID> {

    @Query("""
            SELECT NEW UserEntity(u.id, u.externalId, (CASE WHEN COUNT(u.id) + u.absence <= 3 THEN TRUE ELSE FALSE END), (COUNT(u.id) + u.absence))
            FROM ReservationEntity r
                INNER JOIN ScheduleEntity s ON r.schedule.id = s.id
                INNER JOIN UserEntity u ON r.user.id = u.id
            WHERE s.endTime <= :endTime AND s.endTime > :startTime AND r.completed = FALSE
            GROUP BY u.id, u.externalId, u.absence
            HAVING COUNT(r.user.id) > 0
            """)
    List<UserEntity> listUserAbsence(@Param("startTime") final Instant startTime, @Param("endTime") final Instant endTime);
}
