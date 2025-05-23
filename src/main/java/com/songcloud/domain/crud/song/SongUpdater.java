package com.songcloud.domain.crud.song;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
class SongUpdater {

    private final SongRepository songRepository;

    void updateById(Long id, Song newSong) {
        songRepository.updateById(id, newSong);
    }

}
