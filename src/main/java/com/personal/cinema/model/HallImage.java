package com.personal.cinema.model;

import java.util.UUID;

public class HallImage {
    private final UUID id;
    private final String url;

    public HallImage(final UUID id, final String url) {
        this.id = id;
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
