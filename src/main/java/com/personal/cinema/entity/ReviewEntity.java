package com.personal.cinema.entity;

import com.personal.cinema.model.Review;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String comment;

    @Column(nullable = false)
    private int grade;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ReviewEntity() {
    }

    public ReviewEntity(final UUID id,
                        final String comment,
                        final int grade,
                        final MovieEntity movie,
                        final UserEntity user) {
        this.id = id;
        this.comment = comment;
        this.grade = grade;
        this.movie = movie;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(final int grade) {
        this.grade = grade;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(final MovieEntity movie) {
        this.movie = movie;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(final UserEntity user) {
        this.user = user;
    }

    public Review toDomainModel() {
        return new Review(id, comment, grade, movie.toDomainModal(), user.toDomainModel());
    }

    public static ReviewEntity fromDomainModel(final Review review) {
        return new ReviewEntity(
                review.getId(),
                review.getComment(),
                review.getGrade(),
                MovieEntity.fromDomainModel(review.getMovie()),
                UserEntity.fromDomainModel(review.getUser())
        );
    }
}
