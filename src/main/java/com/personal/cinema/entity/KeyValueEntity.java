package com.personal.cinema.entity;

import com.personal.cinema.model.KeyValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "key_value")
public class KeyValueEntity {

    @Id
    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    public KeyValueEntity() {
    }

    public KeyValueEntity(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public KeyValue toDomainModel() {
        return new KeyValue(key, value);
    }
}
