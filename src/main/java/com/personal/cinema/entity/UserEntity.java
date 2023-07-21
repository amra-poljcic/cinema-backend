package com.personal.cinema.entity;

import com.personal.cinema.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "\"user\"")
public class UserEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "active")
    private boolean active;

    @Column(name = "absence")
    private long absence;

    public UserEntity() {
    }

    public UserEntity(final UUID id, final String externalId, final boolean active, final long absence) {
        this.id = id;
        this.externalId = externalId;
        this.active = active;
        this.absence = absence;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(final String externalId) {
        this.externalId = externalId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public long getAbsence() {
        return absence;
    }

    public void setAbsence(final long absence) {
        this.absence = absence;
    }

    public User toDomainModel() {
        return new User(id, externalId, active, absence);
    }

    public static UserEntity fromDomainModel(final User user) {
        return new UserEntity(user.getId(), user.getExternalId(), user.isActive(), user.getAbsence());
    }
}
