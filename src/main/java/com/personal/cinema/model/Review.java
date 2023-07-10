package com.personal.cinema.model;

import com.personal.cinema.request.ReviewRequest;

import java.util.UUID;

public class Review {
    private final UUID id;
    private final String comment;
    private final int grade;
    private final Movie movie;
    private final User user;

    public Review(final String comment, final int grade, final Movie movie, final User user) {
        this(null, comment, grade, movie, user);
    }

    public Review(final UUID id, final String comment, final int grade, final Movie movie, final User user) {
        this.id = id;
        this.comment = comment;
        this.grade = grade;
        this.movie = movie;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public int getGrade() {
        return grade;
    }

    public Movie getMovie() {
        return movie;
    }

    public User getUser() {
        return user;
    }

    public static Review fromRequest(final ReviewRequest reviewRequest, final Movie movie, final User user) {
        return new Review(reviewRequest.comment(), reviewRequest.grade(), movie, user);
    }
}
