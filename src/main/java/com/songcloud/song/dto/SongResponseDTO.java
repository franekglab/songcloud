package com.songcloud.song.dto;

import java.util.Map;

public record SongResponseDTO(Map<Integer, String> songs) {
}
