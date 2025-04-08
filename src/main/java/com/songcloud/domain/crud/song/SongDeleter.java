package com.songcloud.domain.crud.song;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Log4j2
@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
class SongDeleter {

    private final SongRepository songRepository;

    void deleteById(Long id) {
        log.info("delete song by id:" + id);
        songRepository.deleteById(id);
    }

    void deleteAllSongsById(final Set<Long> songsId) {
        songRepository.deleteByIdIn(songsId);

    }


}
