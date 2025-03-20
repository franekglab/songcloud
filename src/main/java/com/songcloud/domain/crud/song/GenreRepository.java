package com.songcloud.domain.crud.song;

import org.springframework.data.repository.Repository;

interface GenreRepository extends Repository<Genre, Long> {

    Genre save(Genre genre);
}
