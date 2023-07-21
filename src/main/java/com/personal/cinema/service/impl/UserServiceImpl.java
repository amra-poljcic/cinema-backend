package com.personal.cinema.service.impl;

import com.personal.cinema.entity.UserEntity;
import com.personal.cinema.model.User;
import com.personal.cinema.repository.UserRepository;
import com.personal.cinema.service.api.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
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

    @Override
    public List<User> listUserAbsence(final Instant startTime, final Instant endTime) {
        return userRepository.listUserAbsence(startTime, endTime).stream().map(UserEntity::toDomainModel).toList();
    }

    @Override
    public void deactivate(final UUID id) {
        final UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User does not exists"));
        userEntity.setActive(false);

        userRepository.save(userEntity);
    }

    @Override
    public User save(final User user) {
        return userRepository.save(UserEntity.fromDomainModel(user)).toDomainModel();
    }

    @Override
    public List<User> saveAll(final List<User> users) {
        final List<UserEntity> userEntities = users.stream().map(UserEntity::fromDomainModel).toList();
        return userRepository.saveAll(userEntities).stream().map(UserEntity::toDomainModel).toList();
    }
}
