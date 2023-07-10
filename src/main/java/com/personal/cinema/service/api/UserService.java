package com.personal.cinema.service.api;

import com.personal.cinema.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> findById(UUID id);
}
