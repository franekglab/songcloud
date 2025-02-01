package com.songcloud;

import java.util.List;
import java.util.Map;

public record SongResponseDTO(Map<Integer, String> songs) {
}
