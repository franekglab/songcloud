package com.songcloud.infrastructure.crud.song.controller;

import com.songcloud.domain.crud.song.SongCrudFacade;
import com.songcloud.domain.crud.song.SongDto;
import com.songcloud.infrastructure.crud.song.dto.request.CreateSongRequestDto;
import com.songcloud.infrastructure.crud.song.dto.request.PartiallyUpdateSongRequestDto;
import com.songcloud.infrastructure.crud.song.dto.request.UpdateSongRequestDto;
import com.songcloud.infrastructure.crud.song.dto.response.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.songcloud.infrastructure.crud.song.controller.SongControllerMapper.*;

@AllArgsConstructor
@RestController
@Log4j2
@RequestMapping("/songs")
class SongRestController {

    private final SongCrudFacade songFacade;

    @GetMapping
     ResponseEntity<GetAllSongsResponseDto> getAllSongs(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        List<SongDto> allSongs = songFacade.findAll(pageable);
        GetAllSongsResponseDto response = mapFromSongToGetAllSongsResponseDto(allSongs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
     ResponseEntity<GetSongResponseDto> getSongById(@PathVariable Long id,
                                                          @RequestHeader(required = false) String requestId) {
        log.info(requestId);
        SongDto song = songFacade.findSongDtoById(id);
        GetSongResponseDto response = mapFromSongToGetSongResponseDto(song);
        return ResponseEntity.ok(response);
    }

    @PostMapping
     ResponseEntity<CreateSongResponseDto> postSongs(@RequestBody @Valid CreateSongRequestDto request) {
        SongDto songDto = mapFromCreateSongRequestDtoToSongDto(request);
        SongDto savedSong = songFacade.addSong(songDto);
        CreateSongResponseDto body = mapFromSongToCreateSongResponseDto(savedSong);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
     ResponseEntity<DeleteSongResponseDto> deleteSongById(@PathVariable Long id) {
        songFacade.deleteById(id);
        DeleteSongResponseDto body = mapFromSongToDeleteSongResponseDto(id);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
     ResponseEntity<UpdateSongResponseDto> updateSong(@PathVariable Long id,
                                                            @RequestBody @Valid UpdateSongRequestDto request) {
        SongDto newSongDto = mapFromUpdateSongRequestDtoToSongDto(request);
        songFacade.updateById(id, newSongDto);
        UpdateSongResponseDto body = mapFromSongToUpdateSongResponseDto(newSongDto);
        return ResponseEntity.ok(body);
    }


    @PatchMapping("/{id}")
     ResponseEntity<PartiallyUpdateSongResponseDto> partiallyUpdateSong(@PathVariable Long id,
                                                                              @RequestBody PartiallyUpdateSongRequestDto request) {
        SongDto updatedSong = mapFromPartiallyUpdateSongRequestDtoToSong(request);
        SongDto savedSong = songFacade.updatePartiallyById(id, updatedSong);
        PartiallyUpdateSongResponseDto body = mapFromSongDtoToPartiallyUpdateSongResponseDto(savedSong);
        return ResponseEntity.ok(body);
    }


}
