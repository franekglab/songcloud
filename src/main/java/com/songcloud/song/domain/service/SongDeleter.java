package com.songcloud.song.domain.service;

import com.songcloud.song.domain.repository.SongRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class SongDeleter {
    private final SongRepository songRepository;

    private final SongRetriever songRetriever;

    public void deleteById(Long id) {
        songRetriever.existsById(id);
        log.info("delete song by id:" + id);
        songRepository.deleteById(id);
    }
}
