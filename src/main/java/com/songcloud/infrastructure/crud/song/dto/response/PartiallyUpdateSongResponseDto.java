package com.songcloud.infrastructure.crud.song.dto.response;

import com.songcloud.domain.crud.song.SongDto;

public record PartiallyUpdateSongResponseDto(SongDto updatedSong) {

}
