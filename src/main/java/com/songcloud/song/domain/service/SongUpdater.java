package com.songcloud.song.domain.service;

import com.songcloud.song.domain.model.Song;
import com.songcloud.song.domain.repository.SongRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class SongUpdater {

    private final SongRepository songRepository;


    public void updateById(Long id, Song newSong) {
        songRepository.updateById(id, newSong);
    }
}
