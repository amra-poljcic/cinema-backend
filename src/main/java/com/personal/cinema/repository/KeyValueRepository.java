package com.personal.cinema.repository;

import com.personal.cinema.entity.KeyValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KeyValueRepository extends JpaRepository<KeyValueEntity, String> {

    Optional<KeyValueEntity> findByKey(final String key);
}
