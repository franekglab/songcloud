package com.songcloud.domain.crud.song;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
@Log4j2
@Service
@Transactional
class SongAdder {

    private final SongRepository songRepository;

    Song addSong(Song song) {
        log.info("adding new song: " + song);
        song.setDuration(200L);
        song.setReleaseDate(Instant.now());
        return songRepository.save(song);
    }


}
