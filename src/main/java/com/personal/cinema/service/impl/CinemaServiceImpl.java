package com.personal.cinema.service.impl;

import com.personal.cinema.entity.CinemaEntity;
import com.personal.cinema.model.Cinema;
import com.personal.cinema.repository.CinemaRepository;
import com.personal.cinema.service.api.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(final CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Cinema save(final Cinema cinema) {
        return cinemaRepository.save(CinemaEntity.fromDomainModel(cinema)).toDomainModel();
    }

    @Override
    public List<Cinema> list() {
        return cinemaRepository.findAll().stream().map(CinemaEntity::toDomainModel).toList();
    }

    @Override
    public void deleteById(final UUID cinemaId) {
        cinemaRepository.deleteById(cinemaId);
    }
}
