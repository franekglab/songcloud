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
    private final SongRetriever songRetriever;


    public void updateById(Long id, Song newSong) {
        songRetriever.existsById(id);
        songRepository.updateById(id, newSong);
    }

    public Song updatePartiallyById(Long id, Song songFromRequest) {
        Song songFromDatabase = songRetriever.findSongById(id);
        Song.SongBuilder builder = Song.builder();
        if (songFromRequest.getSongName() != null) {
            builder.songName(songFromRequest.getSongName());
        } else {
            builder.songName(songFromDatabase.getSongName());
        }
        if (songFromRequest.getArtistName() != null) {
            builder.artistName(songFromRequest.getArtistName());
        } else {
            builder.artistName(songFromDatabase.getArtistName());
        }
        Song toSave = builder.build();
        updateById(id, toSave);
        return toSave;
    }
}
