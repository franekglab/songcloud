package com.songcloud.infrastructure.crud.song.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSongRequestDto(

        @NotNull(message = "name can not be null")
        @NotEmpty(message = "name can not be empty")
        String songName,

        String artist
) {
}
