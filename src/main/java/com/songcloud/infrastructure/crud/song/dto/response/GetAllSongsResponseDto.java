package com.songcloud.infrastructure.crud.song.dto.response;
import com.songcloud.domain.crud.song.SongDto;

import java.util.List;

public record GetAllSongsResponseDto(List<SongDto> songs) {
}
