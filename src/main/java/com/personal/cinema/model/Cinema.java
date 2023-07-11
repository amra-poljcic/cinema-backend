package com.personal.cinema.model;

import java.util.List;
import java.util.UUID;

public class Cinema {
    private final UUID id;
    private final String name;
    private final List<Image> images;

    public Cinema(final UUID id, final String name, final List<Image> images) {
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

    public List<Image> getImages() {
        return images;
    }

    public Cinema withImages(final List<Image> images) {
        return new Cinema(this.id, this.name, images);
    }
}
