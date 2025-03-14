package com.songcloud.infrastructure.crud.song.dto.response;

import lombok.Builder;

@Builder
public record SongControllerResponseDto(Long id, String name, String artist) {
}
