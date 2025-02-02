package com.songcloud.song.controller;

import com.songcloud.song.dto.DeleteSongResponseDTO;
import com.songcloud.song.dto.SingleSongResponseDTO;
import com.songcloud.song.dto.SongRequestDTO;
import com.songcloud.song.dto.SongResponseDTO;
import com.songcloud.song.error.SongNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Log4j2
public class SongController {

    Map<Integer, String> database = new HashMap<>(Map.of(
            1, "cherry lady",
            2, "apollo",
            3, "mickey rourke",
            4, "who you mam"
    ));

    @GetMapping("/songs")
    public ResponseEntity<SongResponseDTO> getAllSongs(@RequestParam(required = false) Integer limit) {
        if (limit != null) {
            Map<Integer, String> limitedMap = database.entrySet()
                    .stream()
                    .limit(limit)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            SongResponseDTO response = new SongResponseDTO(limitedMap);
            return ResponseEntity.ok(response);
        }
        SongResponseDTO response = new SongResponseDTO(database);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<SingleSongResponseDTO> getSongById(@PathVariable Integer id, @RequestHeader(required = false) String requestId) {
        log.info(requestId);
        if (!database.containsKey(id)) {
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
        String song = database.get(id);
        SingleSongResponseDTO response = new SingleSongResponseDTO(song);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/songs")
    public ResponseEntity<SingleSongResponseDTO> postSongs(@RequestBody @Valid SongRequestDTO request) {
        String songName = request.songName();
        log.info("adding new song: " + songName);
        database.put(database.size() + 1, songName);
        return ResponseEntity.ok(new SingleSongResponseDTO(songName));
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<DeleteSongResponseDTO> deleteSongById(@PathVariable Integer id) {
        if (!database.containsKey(id)) {
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
        database.remove(id);
        return ResponseEntity.ok(new DeleteSongResponseDTO("Song with id: " + id + " has been deleted", HttpStatus.OK));
    }
}
