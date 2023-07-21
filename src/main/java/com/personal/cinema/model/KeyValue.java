package com.personal.cinema.model;

public class KeyValue {
    private final String key;
    private final String value;

    public KeyValue(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
