package com.personal.cinema.entity;

import com.personal.cinema.model.HallImage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "hall_image")
public class HallImageEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private HallEntity hall;

    public HallImageEntity() {
    }

    public HallImageEntity(final UUID id, final String url, final HallEntity hall) {
        this.id = id;
        this.url = url;
        this.hall = hall;
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

    public HallEntity getHall() {
        return hall;
    }

    public void setHall(final HallEntity hall) {
        this.hall = hall;
    }

    public HallImage toDomainModel() {
        return new HallImage(id, url);
    }

    public static HallImageEntity fromDomainModel(final HallImage hallImage) {
        return new HallImageEntity(hallImage.getId(), hallImage.getUrl(), null);
    }
}
