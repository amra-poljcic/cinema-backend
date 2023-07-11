package com.personal.cinema.repository;

import com.personal.cinema.entity.MovieGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenreEntity, UUID> {
}
