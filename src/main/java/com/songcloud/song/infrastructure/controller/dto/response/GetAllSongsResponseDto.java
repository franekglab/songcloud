package com.songcloud.song.infrastructure.controller.dto.response;
import java.util.List;

public record GetAllSongsResponseDto(List<SongDto> songs) {
}
