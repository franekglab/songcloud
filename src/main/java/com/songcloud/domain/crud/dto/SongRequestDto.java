package com.songcloud.domain.crud.dto;

import java.time.Instant;

public record SongRequestDto(String name, Instant releaseDate, Long duration, SongLanguageDto language) {
}
