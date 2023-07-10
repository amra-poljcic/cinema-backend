CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS cinema (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name TEXT
);

CREATE TABLE IF NOT EXISTS cinema_image (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   cinema_id UUID,
   url TEXT,
   CONSTRAINT fk_cinema_image_cinema
       FOREIGN KEY (cinema_id) REFERENCES cinema(id)
);

CREATE TABLE IF NOT EXISTS movie (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    review_average FLOAT,
    review_count INTEGER,
    length TEXT NOT NULL,
    year INTEGER
);

CREATE TABLE IF NOT EXISTS cinema_movie (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    cinema_id UUID,
    movie_id UUID,
    CONSTRAINT fk_cinema_movie_movie
        FOREIGN KEY (movie_id) REFERENCES movie(id),
    CONSTRAINT fk_cinema_movie_cinema
        FOREIGN KEY (cinema_id) REFERENCES cinema(id)
);

CREATE TABLE IF NOT EXISTS movie_image (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    movie_id UUID,
    url TEXT,
    CONSTRAINT fk_movie_image_movie
        FOREIGN KEY (movie_id) REFERENCES movie(id)
);

CREATE TABLE IF NOT EXISTS genre (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS movie_genre (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   genre_id UUID,
   movie_id UUID,
   CONSTRAINT fk_movie_genre_genre
       FOREIGN KEY (genre_id) REFERENCES genre(id),
   CONSTRAINT fk_movie_genre_movie
       FOREIGN KEY (movie_id) REFERENCES movie(id)
);

CREATE TABLE IF NOT EXISTS "user" (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  external_id TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS review (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  user_id UUID,
  movie_id UUID,
  comment TEXT,
  grade INTEGER NOT NULL,
  CONSTRAINT fk_review_user
      FOREIGN KEY (user_id) REFERENCES "user"(id),
  CONSTRAINT fk_review_movie
      FOREIGN KEY (movie_id) REFERENCES movie(id)
);

CREATE TABLE IF NOT EXISTS hall (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name TEXT NOT NULL,
    description TEXT,
    capacity INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS schedule (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    movie_id UUID,
    hall_id UUID,
    date TIMESTAMP,
    price NUMERIC NOT NULL,
    CONSTRAINT fk_schedule_movie
        FOREIGN KEY (movie_id) REFERENCES movie(id),
    CONSTRAINT fk_schedule_hall
        FOREIGN KEY (hall_id) REFERENCES hall(id)
);

CREATE TABLE IF NOT EXISTS seat (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    hall_id UUID,
    row TEXT NOT NULL,
    "column" TEXT NOT NULL,
    CONSTRAINT fk_seat_hall
        FOREIGN KEY (hall_id) REFERENCES hall(id)
);

CREATE TABLE IF NOT EXISTS hall_image (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   hall_id UUID,
   url TEXT,
   CONSTRAINT fk_hall_image_hall
       FOREIGN KEY (hall_id) REFERENCES hall(id)
);

CREATE TABLE IF NOT EXISTS reservation (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   seat_id UUID,
   schedule_id UUID,
   user_id UUID,
   date TIMESTAMP NOT NULL,
   completed BOOLEAN DEFAULT FALSE,
   CONSTRAINT fk_reservation_seat
       FOREIGN KEY (seat_id) REFERENCES seat(id),
   CONSTRAINT fk_reservation_user
       FOREIGN KEY (user_id) REFERENCES "user"(id),
   CONSTRAINT fk_reservation_schedule
       FOREIGN KEY (schedule_id) REFERENCES schedule(id)
);
