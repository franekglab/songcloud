package com.songcloud.song.domain.service;

import com.songcloud.song.domain.model.Song;
import com.songcloud.song.domain.model.SongNotFoundException;
import com.songcloud.song.domain.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class SongRetriever {

    private final SongRepository songRepository;

    public List<Song> findAll() {
        log.info("retrieving all songs: ");
        return songRepository.findAll();
    }

    public List<Song> findAllLimited(Integer limit) {
        return songRepository.findAll().stream().limit(limit).toList();
    }

    public Optional<Song> findSongById(Long id) {
        return songRepository.findById(id);
    }

    public void existById(Long id) {
        findSongById(id).orElseThrow(() -> new SongNotFoundException("Song with id:" + id + " not found"));
    }
}
