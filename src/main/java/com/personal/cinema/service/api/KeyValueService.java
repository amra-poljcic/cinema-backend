package com.personal.cinema.service.api;

import com.personal.cinema.model.KeyValue;

public interface KeyValueService {
    KeyValue put(final String key, final String value);

    String get(final String key);
}
