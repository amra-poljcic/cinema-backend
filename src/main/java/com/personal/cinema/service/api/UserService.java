package com.personal.cinema.service.api;

import com.personal.cinema.model.User;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> findById(UUID id);

    List<User> listUserAbsence(Instant startTime, Instant endTime);

    void deactivate(UUID id);

    User save(User user);

    List<User> saveAll(List<User> users);
}
