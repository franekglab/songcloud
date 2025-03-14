package com.songcloud.infrastructure.crud.song.error;

import org.springframework.http.HttpStatus;

public record ErrorSongResponseDTO(String message, HttpStatus status) {
}
