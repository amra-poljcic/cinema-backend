package com.personal.cinema.service.impl;

import com.personal.cinema.entity.UserEntity;
import com.personal.cinema.model.User;
import com.personal.cinema.repository.UserRepository;
import com.personal.cinema.service.api.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(final UUID id) {
        return userRepository.findById(id).map(UserEntity::toDomainModel);
    }
}
