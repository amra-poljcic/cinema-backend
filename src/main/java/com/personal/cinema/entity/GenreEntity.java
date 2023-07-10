package com.personal.cinema.entity;

import com.personal.cinema.model.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "genre")
public class GenreEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    public GenreEntity() {
    }

    public GenreEntity(final UUID id, final String name) {
        this.id = id;
        this.name = name;
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

    public Genre toDomainModel() {
        return new Genre(id, name);
    }

    public static GenreEntity fromDomainModel(final Genre genre) {
        return new GenreEntity(genre.getId(), genre.getName());
    }
}
