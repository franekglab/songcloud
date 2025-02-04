package com.songcloud.song.domain.repository;


import com.songcloud.song.domain.model.Song;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SongRepository {

    Map<Integer, Song> database = new HashMap<>(Map.of(
            1, new Song("cherry lady", "Louis Villain"),
            2, new Song("apollo", "Avi"),
            3, new Song("mickey rourke", "Sentino"),
            4, new Song("fuego", "Louis Villain")
    ));

    public Song saveToDatabase(Song song) {
        database.put(database.size() + 1, song);
        return song;
    }

    public Map<Integer, Song> findAll() {
        return database;
    }
}
