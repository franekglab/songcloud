package com.songcloud.domain.crud.song;

class AlbumNotFoundException extends RuntimeException {

    AlbumNotFoundException(final String message) {
        super(message);
    }
}
