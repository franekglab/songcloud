package com.songcloud.domain.crud.song;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
@Service
@Log4j2
class SongRetriever {

    private final SongRepository songRepository;

    List<Song> findAll(Pageable pageable) {
        log.info("retrieving all songs: ");
        return songRepository.findAll(pageable);
    }

    void existsById(Long id) {
        if (!songRepository.existsById(id)) {
            throw new SongNotFoundException("Song with id:" + id + " not found");
        }
    }

    Song findSongById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException("Song with id:" + id + " not found"));
    }

}

