package com.songcloud.song.infrastructure.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateSongRequestDto(

        @NotNull(message = "name can not be null")
        @NotEmpty(message = "name can not be empty")
        String songName,

        @NotNull(message = "name can not be null")
        @NotEmpty(message = "name can not be empty")
        String artistName
) {
}
