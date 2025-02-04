package com.songcloud.song.infrastructure.controller;

import com.songcloud.song.domain.repository.SongRepository;
import com.songcloud.song.domain.service.SongAdder;
import com.songcloud.song.domain.service.SongRetriever;
import com.songcloud.song.infrastructure.controller.dto.request.PartiallyUpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.CreateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.UpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.response.*;
import com.songcloud.song.domain.model.SongNotFoundException;
import com.songcloud.song.domain.model.Song;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping("/songs")
public class SongRestController {

    private final SongAdder songAdder;
    private final SongRetriever songRetriever;

    @GetMapping
    public ResponseEntity<GetAllSongsResponseDto> getAllSongs(@RequestParam(required = false) Integer limit) {
        Map<Integer, Song> allSongs = songRetriever.findAll();
        if (limit != null) {
            Map<Integer, Song> limitedMap = songRetriever.findAllLimited(limit);
            GetAllSongsResponseDto response = new GetAllSongsResponseDto(limitedMap);
            return ResponseEntity.ok(response);
        }
        GetAllSongsResponseDto response = SongMapper.mapFromSongToGetAllSongsResponseDto(allSongs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSongResponseDto> getSongById(@PathVariable Integer id, @RequestHeader(required = false) String requestId) {
        log.info(requestId);
        Map<Integer, Song> allSongs = songRetriever.findAll();
        if (!allSongs.containsKey(id)) {
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
        Song song = allSongs.get(id);
        GetSongResponseDto response = SongMapper.mapFromSongToGetSongResponseDto(song);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateSongResponseDto> postSongs(@RequestBody @Valid CreateSongRequestDto request) {
        Song song = SongMapper.mapFromCreateSongRequestDtoToSong(request);
        songAdder.addSong(song);
        CreateSongResponseDto body = SongMapper.mapFromSongToCreateSongResponseDto(song);
        return ResponseEntity.ok(body);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteSongResponseDto> deleteSongById(@PathVariable Integer id) {
        Map<Integer, Song> allSongs = songRetriever.findAll();
        if (!allSongs.containsKey(id)) {
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
        allSongs.remove(id);
        DeleteSongResponseDto body = SongMapper.mapFromSongToDeleteSongResponseDto(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSongResponseDto> updateSong(@PathVariable Integer id,
                                                            @RequestBody @Valid UpdateSongRequestDto request) {
        Map<Integer, Song> allSongs = songRetriever.findAll();
        if (!allSongs.containsKey(id)) {
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
        Song newSong = SongMapper.mapFromUpdateSongRequestDtoToSong(request);
        Song oldSong = allSongs.put(id, newSong);
        log.info("updated song with id: " + id +
                " with oldSongName: " + oldSong.songName() + " to newSongName: " + newSong.songName() +
                " with oldArtist: " + oldSong.artistName() + " to newArtist: " + newSong.artistName());
        UpdateSongResponseDto body = SongMapper.mapFromSongToUpdateSongResponseDto(newSong);
        return ResponseEntity.ok(body);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PartiallyUpdateSongResponseDto> partiallyUpdateSong(@PathVariable Integer id,
                                                                              @RequestBody PartiallyUpdateSongRequestDto request) {
        Map<Integer, Song> allSongs = songRetriever.findAll();
        if (!allSongs.containsKey(id)) {
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
        Song songFromDatabase = allSongs.get(id);
        Song updatedSong = SongMapper.mapFromPartiallyUpdateSongRequestDtoToSong(request);
        Song.SongBuilder builder = Song.builder();
        if (updatedSong.songName() != null) {
            builder.songName(updatedSong.songName());
        } else {
            builder.songName(songFromDatabase.songName());
        }
        if (updatedSong.artistName() != null) {
            builder.artistName(updatedSong.artistName());
        } else {
            builder.artistName(songFromDatabase.artistName());
        }
        allSongs.put(id, updatedSong);
        PartiallyUpdateSongResponseDto body = SongMapper.mapFromSongToPartiallyUpdateSongResponseDto(updatedSong);
        return ResponseEntity.ok(body);
    }


}
