package com.songcloud.song.infrastructure.controller.dto.response;
import com.songcloud.song.domain.model.Song;
import java.util.List;

public record GetAllSongsResponseDto(List<Song> songs) {
}
