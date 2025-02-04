package com.songcloud.song.domain.service;

import com.songcloud.song.domain.model.Song;
import com.songcloud.song.domain.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class SongAdder {

    private final SongRepository songRepository;

    public Song addSong(Song song) {
        log.info("adding new song: " + song);
        songRepository.saveToDatabase(song);
        return song;
    }


}
