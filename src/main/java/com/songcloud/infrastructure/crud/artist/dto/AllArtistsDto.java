package com.songcloud.infrastructure.crud.artist.dto;

import com.songcloud.domain.crud.dto.ArtistDto;

import java.util.Set;

public record AllArtistsDto(Set<ArtistDto> artists) {
}
