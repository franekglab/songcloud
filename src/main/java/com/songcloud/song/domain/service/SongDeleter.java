package com.songcloud.song.domain.service;

import com.songcloud.song.domain.model.Song;
import com.songcloud.song.domain.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SongDeleter {
    private final SongRepository songRepository;

    public void deleteById(Long id) {
        log.info("delete song by id:" + id);
        songRepository.deleteById(id);
    }
}
