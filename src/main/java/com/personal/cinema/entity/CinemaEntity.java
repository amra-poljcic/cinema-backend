package com.personal.cinema.entity;

import com.personal.cinema.model.Cinema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cinema")
public class CinemaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CinemaImageEntity> images;

    public CinemaEntity() {
    }

    public CinemaEntity(final UUID id, final String name, final List<CinemaImageEntity> images) {
        this.id = id;
        this.name = name;
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

    public List<CinemaImageEntity> getImages() {
        return images;
    }

    public void setImages(final List<CinemaImageEntity> images) {
        this.images = images;
    }

    public Cinema toDomainModel() {
        return new Cinema(id, name, images.stream().map(CinemaImageEntity::toDomainModel).toList());
    }

    public static CinemaEntity fromDomainModel(final Cinema cinema) {
        return new CinemaEntity(
                cinema.getId(),
                cinema.getName(),
                Collections.emptyList()
        );
    }
}
