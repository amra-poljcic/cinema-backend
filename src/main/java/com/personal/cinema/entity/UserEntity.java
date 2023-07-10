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

    public UserEntity() {
    }

    public UserEntity(final UUID id, final String externalId) {
        this.id = id;
        this.externalId = externalId;
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

    public User toDomainModel() {
        return new User(id, externalId);
    }

    public static UserEntity fromDomainModel(final User user) {
        return new UserEntity(user.getId(), user.getExternalId());
    }
}
