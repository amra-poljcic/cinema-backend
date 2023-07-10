package com.personal.cinema.model;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String externalId;

    public User(final UUID id, final String externalId) {
        this.id = id;
        this.externalId = externalId;
    }

    public UUID getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }
}
