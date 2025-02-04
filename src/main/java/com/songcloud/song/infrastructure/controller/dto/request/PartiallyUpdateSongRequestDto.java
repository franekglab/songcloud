package com.songcloud.song.infrastructure.controller.dto.request;

public record PartiallyUpdateSongRequestDto(

        String songName,
        String artistName
) {
}
