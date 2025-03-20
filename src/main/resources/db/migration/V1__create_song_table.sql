CREATE TABLE song
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    release_date TIMESTAMP WITH TIME ZONE,
    duration     BIGINT,
    language     VARCHAR(255)
);
