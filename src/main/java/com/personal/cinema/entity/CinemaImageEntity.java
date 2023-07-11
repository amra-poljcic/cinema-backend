package com.personal.cinema.entity;

import com.personal.cinema.model.Image;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "cinema_image")
public class CinemaImageEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private CinemaEntity cinema;

    public CinemaImageEntity() {
    }

    public CinemaImageEntity(final UUID id, final String url, final CinemaEntity cinema) {
        this.id = id;
        this.url = url;
        this.cinema = cinema;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public CinemaEntity getCinema() {
        return cinema;
    }

    public void setCinema(final CinemaEntity cinema) {
        this.cinema = cinema;
    }

    public Image toDomainModel() {
        return new Image(id, url);
    }

    public static CinemaImageEntity fromDomainModel(final Image image, final CinemaEntity cinemaEntity) {
        return new CinemaImageEntity(image.getId(), image.getUrl(), cinemaEntity);
    }
}
