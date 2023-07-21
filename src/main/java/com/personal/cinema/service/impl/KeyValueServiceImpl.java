package com.personal.cinema.service.impl;

import com.personal.cinema.entity.KeyValueEntity;
import com.personal.cinema.model.KeyValue;
import com.personal.cinema.repository.KeyValueRepository;
import com.personal.cinema.service.api.KeyValueService;
import org.springframework.stereotype.Service;

@Service
public class KeyValueServiceImpl implements KeyValueService {

    private final KeyValueRepository keyValueRepository;

    public KeyValueServiceImpl(final KeyValueRepository keyValueRepository) {
        this.keyValueRepository = keyValueRepository;
    }

    @Override
    public KeyValue put(final String key, final String value) {
        return keyValueRepository.save(new KeyValueEntity(key, value)).toDomainModel();
    }

    @Override
    public String get(final String key) {
        return keyValueRepository.findByKey(key).map(KeyValueEntity::getValue).orElse(null);
    }
}
