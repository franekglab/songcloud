CREATE TABLE song
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    artist       VARCHAR(255) NOT NULL,
    release_date TIMESTAMP WITHOUT TIME ZONE,
    duration     BIGINT,
    language     VARCHAR(255)
);

CREATE SEQUENCE IF NOT EXISTS song_id_seq START WITH 1 INCREMENT BY 1;
