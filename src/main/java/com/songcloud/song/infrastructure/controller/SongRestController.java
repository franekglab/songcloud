package com.songcloud.song.infrastructure.controller;

import com.songcloud.song.domain.service.SongAdder;
import com.songcloud.song.domain.service.SongDeleter;
import com.songcloud.song.domain.service.SongRetriever;
import com.songcloud.song.domain.service.SongUpdater;
import com.songcloud.song.infrastructure.controller.dto.request.PartiallyUpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.CreateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.request.UpdateSongRequestDto;
import com.songcloud.song.infrastructure.controller.dto.response.*;
import com.songcloud.song.domain.model.SongNotFoundException;
import com.songcloud.song.domain.model.Song;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping("/songs")
public class SongRestController {

    private final SongAdder songAdder;
    private final SongRetriever songRetriever;
    private final SongDeleter songDeleter;
    private final SongUpdater songUpdater;

    @GetMapping
    public ResponseEntity<GetAllSongsResponseDto> getAllSongs(@RequestParam(required = false) Integer limit) {
        List<Song> allSongs = songRetriever.findAll();
        if (limit != null) {
            List<Song> limitedMap = songRetriever.findAllLimited(limit);
            GetAllSongsResponseDto response = new GetAllSongsResponseDto(limitedMap);
            return ResponseEntity.ok(response);
        }
        GetAllSongsResponseDto response = SongMapper.mapFromSongToGetAllSongsResponseDto(allSongs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSongResponseDto> getSongById(@PathVariable Long id, @RequestHeader(required = false) String requestId) {
        log.info(requestId);
        Song song = songRetriever.findSongById(id)
                .orElseThrow(() -> new SongNotFoundException("Song with id " + id + " not found"));
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
    public ResponseEntity<DeleteSongResponseDto> deleteSongById(@PathVariable Long id) {

        songRetriever.existById(id);
        songDeleter.deleteById(id);
        DeleteSongResponseDto body = SongMapper.mapFromSongToDeleteSongResponseDto(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSongResponseDto> updateSong(@PathVariable Long id,
                                                            @RequestBody @Valid UpdateSongRequestDto request) {
        songRetriever.existById(id);
        Song newSong = SongMapper.mapFromUpdateSongRequestDtoToSong(request);
        songUpdater.updateById(id, newSong);
        UpdateSongResponseDto body = SongMapper.mapFromSongToUpdateSongResponseDto(newSong);
        return ResponseEntity.ok(body);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<PartiallyUpdateSongResponseDto> partiallyUpdateSong(@PathVariable Integer id,
                                                                              @RequestBody PartiallyUpdateSongRequestDto request) {
        List<Song> allSongs = songRetriever.findAll();
        if (!allSongs.contains(id)) {
            throw new SongNotFoundException("Song with id: " + id + " not found");
        }
        Song songFromDatabase = allSongs.get(id);
        Song updatedSong = SongMapper.mapFromPartiallyUpdateSongRequestDtoToSong(request);
        Song.SongBuilder builder = Song.builder();
        if (updatedSong.getSongName() != null) {
            builder.songName(updatedSong.getSongName());
        } else {
            builder.songName(songFromDatabase.getSongName());
        }
        if (updatedSong.getArtistName() != null) {
            builder.artistName(updatedSong.getArtistName());
        } else {
            builder.artistName(songFromDatabase.getArtistName());
        }
        songAdder.addSong(updatedSong);
        PartiallyUpdateSongResponseDto body = SongMapper.mapFromSongToPartiallyUpdateSongResponseDto(updatedSong);
        return ResponseEntity.ok(body);
    }


}
