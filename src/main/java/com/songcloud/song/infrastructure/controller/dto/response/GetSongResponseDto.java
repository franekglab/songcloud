package com.songcloud.song.infrastructure.controller.dto.response;

import com.songcloud.song.domain.model.Song;

public record GetSongResponseDto(Song song) {
}
