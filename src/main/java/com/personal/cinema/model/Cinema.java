package com.personal.cinema.model;

import java.util.List;
import java.util.UUID;

public class Cinema {
    private final UUID id;
    private final String name;
    private final List<CinemaImage> images;

    public Cinema(final UUID id, final String name, final List<CinemaImage> images) {
        this.id = id;
        this.name = name;
        this.images = images;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CinemaImage> getImages() {
        return images;
    }
}
