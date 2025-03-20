package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.dto.GenreDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class GenreAdder {

    private final GenreRepository genreRepository;

    GenreDto addGenre(final String name) {
        Genre genre = new Genre(name);
        Genre save = genreRepository.save(genre);
        return new GenreDto(save.getId(), save.getName());
    }
}
