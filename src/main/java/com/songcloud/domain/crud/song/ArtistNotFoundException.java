package com.songcloud.domain.crud.song;

class ArtistNotFoundException extends RuntimeException {
    ArtistNotFoundException(String message) {
        super("Artist with id: " + message + " not found");
    }
}
