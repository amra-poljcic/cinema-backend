package com.personal.cinema.request;

import java.util.UUID;

public record ReservationRequest(UUID seatId, UUID scheduleId, UUID userId) {
}
