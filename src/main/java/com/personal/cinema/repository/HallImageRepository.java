package com.personal.cinema.repository;

import com.personal.cinema.entity.HallImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HallImageRepository extends JpaRepository<HallImageEntity, UUID> {
}
