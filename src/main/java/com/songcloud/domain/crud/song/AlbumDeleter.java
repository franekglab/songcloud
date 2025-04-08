package com.songcloud.domain.crud.song;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
class AlbumDeleter {

    private final AlbumRepository albumRepository;

    void deleteAllAlbumsByIds(Set<Long> albumIdsToDelete) {
        albumRepository.deleteByIdIn(albumIdsToDelete);
    }
}
