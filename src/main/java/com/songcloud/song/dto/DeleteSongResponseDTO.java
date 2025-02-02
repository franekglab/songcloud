package com.songcloud.song.dto;

import org.springframework.http.HttpStatus;

public record DeleteSongResponseDTO(String message, HttpStatus status) {
}
