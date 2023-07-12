package com.personal.cinema.model;

import java.util.List;
import java.util.UUID;

public class Hall {
    private final UUID id;
    private final String name;
    private final String description;
    private final int capacity;
    private final List<Image> images;

    public Hall(final UUID id,
                final String name,
                final String description,
                final int capacity,
                final List<Image> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public UUID getId() {
        return id;
    }

    public List<Image> getImages() {
        return images;
    }

    public Hall withImages(final List<Image> images) {
        return new Hall(this.id, this.name, this.description, this.capacity, images);
    }
}
