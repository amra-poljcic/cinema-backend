package com.personal.cinema.request;

import java.util.UUID;

public record ReviewRequest(UUID userId, UUID movieId, String comment, int grade) {
}
