package com.personal.cinema.entity;

import com.personal.cinema.model.Hall;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "hall")
public class HallEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HallImageEntity> images;

    public HallEntity() {
    }

    public HallEntity(final UUID id,
                      final String name,
                      final String description,
                      final int capacity,
                      final List<HallImageEntity> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.images = images;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(final int capacity) {
        this.capacity = capacity;
    }

    public List<HallImageEntity> getImages() {
        return images;
    }

    public void setImages(final List<HallImageEntity> images) {
        this.images = images;
    }

    public Hall toDomainModel() {
        return new Hall(id, name, description, capacity, images.stream().map(HallImageEntity::toDomainModel).toList());
    }

    public static HallEntity fromDomainModel(final Hall hall) {
        return new HallEntity(
                hall.getId(),
                hall.getName(),
                hall.getDescription(),
                hall.getCapacity(),
                hall.getImages().stream().map(HallImageEntity::fromDomainModel).toList()
        );
    }
}
