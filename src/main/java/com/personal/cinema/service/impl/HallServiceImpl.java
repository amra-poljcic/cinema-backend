package com.personal.cinema.service.impl;

import com.personal.cinema.entity.HallEntity;
import com.personal.cinema.entity.HallImageEntity;
import com.personal.cinema.model.Hall;
import com.personal.cinema.model.Image;
import com.personal.cinema.repository.HallImageRepository;
import com.personal.cinema.repository.HallRepository;
import com.personal.cinema.service.api.HallService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;
    private final HallImageRepository hallImageRepository;

    public HallServiceImpl(final HallRepository hallRepository, final HallImageRepository hallImageRepository) {
        this.hallRepository = hallRepository;
        this.hallImageRepository = hallImageRepository;
    }

    @Transactional
    @Override
    public Hall save(final Hall hall) {
        final HallEntity hallEntity = hallRepository.save(HallEntity.fromDomainModel(hall));
        final List<Image> savedImages = new ArrayList<>(hall.getImages().size());

        for (final Image image : hall.getImages()) {
            final Image savedImage = hallImageRepository
                    .save(HallImageEntity.fromDomainModel(image, hallEntity))
                    .toDomainModel();
            savedImages.add(savedImage);
        }

        return hallEntity.toDomainModel().withImages(savedImages);
    }

    @Override
    public List<Hall> list() {
        return hallRepository.findAll().stream().map(HallEntity::toDomainModel).toList();
    }

    @Override
    public void deleteById(final UUID id) {
        hallRepository.deleteById(id);
    }

    @Override
    public Optional<Hall> findById(final UUID id) {
        return hallRepository.findById(id).map(HallEntity::toDomainModel);
    }
}
