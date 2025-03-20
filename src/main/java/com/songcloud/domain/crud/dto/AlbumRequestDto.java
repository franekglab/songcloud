package com.songcloud.domain.crud.dto;

import java.time.Instant;

public record AlbumRequestDto(String name, Instant releaseDate, Long songId) {
}
