package com.songcloud.song.infrastructure.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSongRequestDto(

        @NotNull(message = "songName can not be null")
        @NotEmpty(message = "songName can not be empty")
        String songName,

        @NotNull(message = "artistName can not be null")
        @NotEmpty(message = "artistName can not be empty")
        String artistName
) {
}
