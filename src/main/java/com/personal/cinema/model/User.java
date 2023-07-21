package com.personal.cinema.model;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String externalId;
    private final boolean active;
    private final long absence;

    public User(final UUID id, final String externalId, final boolean active, final long absence) {
        this.id = id;
        this.externalId = externalId;
        this.active = active;
        this.absence = absence;
    }

    public UUID getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public boolean isActive() {
        return active;
    }

    public long getAbsence() {
        return absence;
    }
}
