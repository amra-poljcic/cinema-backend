package com.personal.cinema.request;

import java.time.Instant;
import java.util.UUID;

public record ReservationRequest(UUID seatId,
                                 UUID scheduleId,
                                 UUID userId,
                                 Instant date) {
}
