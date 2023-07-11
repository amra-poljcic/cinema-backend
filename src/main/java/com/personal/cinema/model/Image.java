package com.personal.cinema.model;

import java.util.UUID;

public class Image {
    private final UUID id;
    private final String url;

    public Image(final UUID id, final String url) {
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
