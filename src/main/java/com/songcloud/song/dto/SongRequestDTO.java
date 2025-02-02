package com.songcloud.song.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SongRequestDTO(
        @NotNull(message = "songName can not be null")
        @NotEmpty(message = "songName can not be empty")
        String songName,

        @NotNull(message = "artistName can not be null")
        @NotEmpty(message = "artistName can not be empty")
        String artistName
) {
}
