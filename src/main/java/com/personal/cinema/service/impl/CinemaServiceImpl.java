package com.personal.cinema.service.impl;

import com.personal.cinema.entity.CinemaEntity;
import com.personal.cinema.entity.CinemaImageEntity;
import com.personal.cinema.model.Cinema;
import com.personal.cinema.model.Image;
import com.personal.cinema.repository.CinemaImageRepository;
import com.personal.cinema.repository.CinemaRepository;
import com.personal.cinema.service.api.CinemaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaImageRepository cinemaImageRepository;

    public CinemaServiceImpl(final CinemaRepository cinemaRepository, final CinemaImageRepository cinemaImageRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaImageRepository = cinemaImageRepository;
    }

    @Override
    public Cinema save(final Cinema cinema) {
        final CinemaEntity cinemaEntity = cinemaRepository.save(CinemaEntity.fromDomainModel(cinema));

        final List<Image> savedImages = new ArrayList<>(cinema.getImages().size());
        for (final Image image : cinema.getImages()){
            final Image savedImage = cinemaImageRepository
                    .save(CinemaImageEntity.fromDomainModel(image, cinemaEntity)).toDomainModel();
            savedImages.add(savedImage);
        }

        return cinemaEntity.toDomainModel().withImages(savedImages);
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
