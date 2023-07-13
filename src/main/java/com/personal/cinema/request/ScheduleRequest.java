package com.personal.cinema.request;

import java.time.Instant;
import java.util.UUID;

public record ScheduleRequest(Instant startTime,
                              Instant endTime,
                              double price,
                              UUID movieId,
                              UUID hallId) {
    public ScheduleRequest withEndTime(final Instant endTime) {
        return new ScheduleRequest(startTime, endTime, price, movieId, hallId);
    }
}
