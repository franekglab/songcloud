package com.songcloud.infrastructure.crud.song.dto.request;

public record PartiallyUpdateSongRequestDto(

        String songName,
        String artist
) {
}
