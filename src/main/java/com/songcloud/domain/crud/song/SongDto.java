package com.songcloud.domain.crud.song;

import lombok.Builder;

@Builder
public record SongDto(Long id, String name) {
}
