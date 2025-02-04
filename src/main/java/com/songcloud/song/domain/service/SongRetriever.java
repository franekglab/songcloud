package com.songcloud.song.domain.service;

import com.songcloud.song.domain.model.Song;
import com.songcloud.song.domain.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class SongRetriever {

    private final SongRepository songRepository;

    public Map<Integer, Song> findAll() {
        log.info("retrieving all songs: ");
        return songRepository.findAll();
    }

    public Map<Integer, Song> findAllLimited(Integer limit) {
        return songRepository.findAll().entrySet()
                .stream()
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
